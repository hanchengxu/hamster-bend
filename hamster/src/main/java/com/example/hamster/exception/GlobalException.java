package com.example.hamster.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.example.hamster.config.LogAspect;
import com.example.hamster.constant.ResponseCode;

/**
 * handle Global Exception
 * write log and return a global error json
 * @author 10087
 *
 */
@Component
public class GlobalException implements HandlerExceptionResolver{

	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		logger.error(ex.toString());

		// return code=99 when catch all Exception at least now
		ModelAndView mv = new ModelAndView();
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		mv.setView(view);
		mv.addObject("code", ResponseCode.SYS_ERROR);
		mv.addObject("message", "system error");

		return mv;
	}

}
