package com.example.hamster.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.hamster.controller.bean.FeedFoodBean;
import com.example.hamster.service.bean.FeedFoodMqttBean;
import com.example.hamster.utils.HttpClientPool;
import com.example.hamster.utils.HttpUtils;

@Service
public class FeedFoodService {

	@Value("${mqtt.server.url}")
	private String mqttURL;

	@Value("${mqtt.server.user}")
	private String mqttUser;

	@Value("${mqtt.server.password}")
	private String mqttPass;

	public void feedFood(FeedFoodBean feedFoodBean) {

		//TODO check feedFoodBean.hamsterId is in DB

		CloseableHttpClient client = HttpClientPool.getInstance().getHttpClient();

		String feedFoodURL = mqttURL + "/api/v4/mqtt/publish";

		Map<String,String> header = new HashMap<String,String>();
		//Basic auth
		header.put("Authorization", "Basic " + Base64.getUrlEncoder().encodeToString((mqttUser+":"+mqttPass).getBytes()));

		FeedFoodMqttBean bean = new FeedFoodMqttBean();
		bean.setPayload("{'runTime':"+feedFoodBean.getFeedTime()+"}");

		HttpUtils.postJSON(feedFoodURL,header,JSON.toJSONString(bean),"");

	}

}
