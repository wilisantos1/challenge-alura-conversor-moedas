package br.com.alura.conversor_moedas;

import java.net.URI;
import java.net.URISyntaxException;

public class HttpRequest {
    private String url;

    public HttpRequest(String url) {
        this.url = url;
    }

    public URI getUri() throws URISyntaxException {
        return new URI(this.url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
