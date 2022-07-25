package com.example.hamster.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);
	
	private final String CLAIM_KEY_USER_EMAIL = "sub";
	private final String CLAIM_KEY_CREATED = "created";

	@Value("${jwt.secret}")
	private String secret;

	//秒单位
	@Value("${jwt.expiration}")
	private Long expiration;

	private String generateToken(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	private Claims getClaimsFromToken(String token) {
		Claims claims = null;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			LOGGER.info("Token is invalid:{}", token);
		}
		return claims;
	}

	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + expiration*1000);
	}

	public String getUserNameFromToken(String token) {
		String username;
		try {
			Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	public String getValueFromToken(String token, String key) {
		String value;
		try {
			Claims claims = getClaimsFromToken(token);
			value = claims.get(key).toString();
		} catch (Exception e) {
			value = null;
		}
		return value;
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		String username = getUserNameFromToken(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}

	private boolean isTokenExpired(String token) {
		Date expiredDate = getExpiredDateFromToken(token);
		return expiredDate.before(new Date());
	}

	private Date getExpiredDateFromToken(String token) {
		Claims claims = getClaimsFromToken(token);
		return claims.getExpiration();
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put(CLAIM_KEY_USER_EMAIL, userDetails.getUsername());
		claims.put(CLAIM_KEY_CREATED, new Date());
		return generateToken(claims);
	}

	public boolean canRefresh(String token) {
		return !isTokenExpired(token);
	}

	public String refreshToken(String token) {
		Claims claims = getClaimsFromToken(token);
		claims.put(CLAIM_KEY_CREATED, new Date());
		return generateToken(claims);
	}
	
}
