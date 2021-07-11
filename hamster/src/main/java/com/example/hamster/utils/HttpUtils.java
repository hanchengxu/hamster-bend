package com.example.hamster.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.example.hamster.exception.HttpResponseException;

public class HttpUtils {

	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	public static void postJSON(String url, Map<String, String> headers, String jsonBody, String reqCharset) {

		logger.debug("POST:[" + url + "]");
		logger.debug("POST JSON BODY:[" + jsonBody + "]");

		HttpPost post = new HttpPost(url);

		if (headers != null) {
			for (String name : headers.keySet()) {
				String value = headers.get(name);
				post.addHeader(name, value);
			}
		}
		post.addHeader("Content-type", "application/json; charset=utf-8");
		post.addHeader("Accept", "application/json");

		if (!StringUtils.isEmpty(jsonBody)) {
			if (reqCharset != null && reqCharset.length() != 0) {
				post.setEntity(new StringEntity(jsonBody, reqCharset));
			} else {
				post.setEntity(new StringEntity(jsonBody, Consts.UTF_8));
			}
		}

		CloseableHttpResponse response = null;
		CloseableHttpClient client = null;

		try {
			client = HttpClientPool.getInstance().getHttpClient();
			System.out.println(client.toString());
			response = client.execute(post);

			int code = response.getStatusLine().getStatusCode();

			// throw exception except code 200
			if (200 != code) {
				HttpResponseException exc = new HttpResponseException("response code:" + code);
				if (null != response.getEntity()) {
					exc.setResponseBody(EntityUtils.toString(response.getEntity()));
				}
				throw exc;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
