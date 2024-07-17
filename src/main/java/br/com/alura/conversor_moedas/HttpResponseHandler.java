package br.com.alura.conversor_moedas;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpResponseHandler {
    private int statusCode;
    private String body;

    public HttpResponseHandler(HttpResponse response) throws IOException {
        this.statusCode = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        this.body = entity != null ? EntityUtils.toString(entity) : null;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }
}
