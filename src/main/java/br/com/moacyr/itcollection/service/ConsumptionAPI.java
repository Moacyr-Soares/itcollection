package br.com.moacyr.itcollection.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumptionAPI {
    public String getData(String url){
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = null;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        //log
        int statusCode = response.statusCode();
        System.out.println("HTTP Status Code: " + statusCode);

        String responseBody = response.body();

        if (responseBody == null || responseBody.isEmpty()){
            System.out.println("A resposta da API está vazia");
        }
        return responseBody;
    }
}
