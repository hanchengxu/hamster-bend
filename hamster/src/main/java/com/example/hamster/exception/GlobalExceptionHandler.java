package com.example.hamster.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.example.hamster.constant.ResponseCode;

/**
 * handle Global Exception write log and return a global error json
 * 
 * @author 10087
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView doResolveExceptionMSRPE(HttpServletRequest request, HttpServletResponse response, Exception ex) {

		logger.error(ex.toString());

		// return code=99 when catch all Exception at least now
		ModelAndView mv = new ModelAndView();
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		mv.setView(view);
		mv.addObject("code", ResponseCode.SYS_ERROR);
		mv.addObject("message", ex.getMessage());

		return mv;
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Exception ex) {

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
