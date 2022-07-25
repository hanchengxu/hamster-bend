package com.example.hamster.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.hamster.service.CustomUserDetailsService;
import com.example.hamster.utils.JwtUtils;

@Configuration
@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	JwtUtils jwtUtils;
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors().and().csrf().disable()
		.exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
			@Override
			public void commence(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException authException) throws IOException, ServletException {
				response.setContentType("application/json;charset=utf-8");
				response.setStatus(401);
                PrintWriter out = response.getWriter();
                String s = "{\"status\":\"fail\",\"msg\":\"you should login\",\"error\":\""+authException.getMessage()+"\"}";
                out.write(s);
                out.flush();
                out.close();
			}
         }).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests().antMatchers("/api/auth/**").permitAll()
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated();

		http.addFilterBefore(new OncePerRequestFilter(){
			@Override
			protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
					FilterChain filterChain) throws ServletException, IOException {
				// 获取cookie中的 jwt
				Cookie jwtCookie = null;
				Cookie[] cookies = request.getCookies();
				if(null != cookies) {
					for(Cookie cookie: cookies) {
						if("signCookie".equals(cookie.getName())) {
							jwtCookie= cookie;
						}
					}
				}
				
		        String authToken = jwtCookie != null?jwtCookie.getValue():null;
		        
		        // 获取到当前用户的username
		        String username = jwtUtils.getUserNameFromToken(authToken);
		        
		        logger.debug("自定义JWT过滤器获得用户名为"+username);
		        
		        // 当token中的username不为空时进行验证token是否是有效的token
		        if (StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
		        	 // token中username不为空，并且Context中的认证为空，进行token验证
		        	
		        	// 获取到用户的信息，也就是获取到用户的权限
		            UserDetails userDetails =userDetailsService.loadUserByUsername(username);
		            
		        	// 验证当前token是否有效
		        	if (jwtUtils.validateToken(authToken,userDetails)) {
		        		UsernamePasswordAuthenticationToken authentication =
		                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		 
		                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		                //将authentication放入SecurityContextHolder中
		                SecurityContextHolder.getContext().setAuthentication(authentication);
		        	}
		        }
		        // 放行给下个过滤器
		        filterChain.doFilter(request, response);
			}
		}, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
}
