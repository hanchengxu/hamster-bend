package com.example.hamster.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.hamster.controller.bean.LoginUserBean;
import com.example.hamster.utils.JwtUtils;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Value("${https.open}")
	private Boolean httpsOpen;
	
	@Value("${jwt.cookie.name}")
	private String cookieName;
	
	@Autowired
	JwtUtils jwtUtils;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/signin")
	public ResponseEntity<?> login(@RequestBody LoginUserBean user) throws Exception {
		String s = "";
		Authentication authObject = null;
		try {
			authObject = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
			
			SecurityContextHolder.getContext().setAuthentication(authObject);
			
			String jwtToken = jwtUtils.generateToken((UserDetails)authObject.getPrincipal());
			
			logger.debug("生成jwtToken: "+jwtToken);
			
			s = "{\"status\":\"success\"}";
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			
			//获取response
			HttpServletResponse response =attributes.getResponse();
			//将jwt token 放入cookie
			Cookie cookie = new Cookie(cookieName,jwtToken);
			cookie.setPath("/");
			cookie.setHttpOnly(true);
			if(httpsOpen) {
				cookie.setSecure(true);
			}
			cookie.setMaxAge(60 * 60 * 24);
			
			response.addCookie(cookie);
			
		} catch (Exception exception) {
			
			StringBuffer sb = new StringBuffer();
            sb.append("{\"status\":\"error\",\"msg\":\"");
            if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
                sb.append("用户名或密码输入错误，登录失败!");
            } else if (exception instanceof DisabledException) {
                sb.append("账户被禁用，登录失败，请联系管理员!");
            } else {
                sb.append("登录失败!");
            }
            sb.append("\"}");
            s = sb.toString();
            
            logger.error(exception.toString());
		}

		return ResponseEntity.ok(s);
	}

}
