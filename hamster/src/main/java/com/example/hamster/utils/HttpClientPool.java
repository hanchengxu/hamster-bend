package com.example.hamster.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientPool {

    private CloseableHttpClient httpclient;


    private static class HttpClientPoolInstance{
        private static final HttpClientPool instance = new HttpClientPool();
    }

    private HttpClientPool() {

        /**
         * some config about connection's  timeout
         */
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(30*1000)
                .setConnectionRequestTimeout(30*1000)
                .setSocketTimeout(30*1000)
                .build();

        /**
         * 1.ConnectTImeout 30s
         * 2.Assigns maximum total connection value.
         */
        httpclient = HttpClients.custom()
                .setDefaultRequestConfig(config)
                .setMaxConnTotal(30)
                .setMaxConnPerRoute(10)
                .build();
    }

    public static HttpClientPool getInstance() {
        return HttpClientPoolInstance.instance;
    }

    public CloseableHttpClient getHttpClient() {
        return this.httpclient;
    }

}