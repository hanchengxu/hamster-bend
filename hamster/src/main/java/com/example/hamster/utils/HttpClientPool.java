package com.example.hamster.utils;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientPool {

    private CloseableHttpClient httpclient;


    private static class HttpClientPoolInstance{
        private static final HttpClientPool instance = new HttpClientPool();
    }

    private HttpClientPool() {
        /**
         * Assigns maximum total connection value.
         * default: 30
         */
        httpclient = HttpClients.custom().setMaxConnTotal(30).setMaxConnPerRoute(15).build();
    }

    public static HttpClientPool getInstance() {
        return HttpClientPoolInstance.instance;
    }

    public CloseableHttpClient getHttpClient() {
        return this.httpclient;
    }

}