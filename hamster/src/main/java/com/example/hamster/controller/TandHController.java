package com.example.hamster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hamster.service.TandHService;

@RestController
@RequestMapping("/api")
public class TandHController {

	@Autowired
	TandHService service;

	/**
	 * 保存环境温湿度和加热垫温度
	 * @param saveTandHBean
	 * @return
	 */
	@RequestMapping(value = "/noauth/saveTandH", method = RequestMethod.POST)
	public ResultMsg saveTandH(@RequestBody com.example.hamster.controller.bean.SaveTandHPayload SaveTandHPayload){

		ResultMsg result = service.save(SaveTandHPayload.getMsg());

		return result;
	}

}
