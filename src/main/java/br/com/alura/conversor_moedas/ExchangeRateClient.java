package br.com.alura.conversor_moedas;


import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class ExchangeRateClient {
    private static final String API_KEY = "60cede6c3957129ce70ac281";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public HttpResponseHandler getExchangeRate(String fromCurrency, String toCurrency) throws IOException {
        String url = API_URL + API_KEY + "/pair/" + fromCurrency + "/" + toCurrency;
        HttpRequest request = new HttpRequest(url);
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(request.getUri());
            org.apache.http.HttpResponse response = httpClient.execute(httpGet);
            return new HttpResponseHandler(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}