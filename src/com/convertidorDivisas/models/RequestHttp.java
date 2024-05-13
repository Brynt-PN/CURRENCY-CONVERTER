package com.convertidorDivisas.models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestHttp {

    private HttpClient client = HttpClient.newHttpClient();
    private HttpRequest request;
    private HttpResponse<String>response;
    private JsonManager jsonManager = new JsonManager();
    private String urlBase = "https://v6.exchangerate-api.com/v6/a7289b972b35bd035c82e724/pair/";

    public void executeRequest(String divisa_1, String divisa_2, double amount) throws IOException, InterruptedException {
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(urlBase + divisa_1 + "/" + divisa_2 + "/" + amount))
                .build();
        this.response = this.client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(jsonManager.instanceJson(response.body(),amount));
    }


}
