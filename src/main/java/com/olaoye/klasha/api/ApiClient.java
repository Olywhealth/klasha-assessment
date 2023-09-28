package com.olaoye.klasha.api;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

@Slf4j
public class ApiClient {
    public static String sendOkHttpRequestCountry(String urlLink, String country) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"country\": \"" + country + "\"}");
        Request request = new Request.Builder()
                .url(urlLink)
                .method("POST", body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            log.info("RESPONSE: {}", response);
            assert response.body() != null;
            return response.body().string();
        }
    }


    public static String sendOkHttpRequestStateAndCountry(String urlLink, String country, String state) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\"country\": \"" + country + "\",\n \"state\": \"" + state + "\"\n}");
        Request request = new Request.Builder()
                .url(urlLink)
                .method("POST", body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            log.info("RESPONSE: {}", response);
            assert response.body() != null;
            return response.body().string();
        }
    }

    public static String sendOkHttpRequestCity(String urlLink, String city) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\"city\": \"" + city + "\"\n}");
        Request request = new Request.Builder()
                .url(urlLink)
                .method("POST", body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            log.info("RESPONSE: {}", response);
            assert response.body() != null;
            return response.body().string();
        }
    }
}