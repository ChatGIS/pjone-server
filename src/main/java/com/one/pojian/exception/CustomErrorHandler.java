package com.one.pojian.exception;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * @author ：ChatGIS
 * @description：RestTemplate异常处理
 */
public class CustomErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return true;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

    }
}
