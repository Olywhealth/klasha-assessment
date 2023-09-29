package com.olaoye.klasha.api;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

@Slf4j
public class ApiClient {




    public static String sendOkHttpRequest(String urlLink, String requestType, String... params) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        String jsonBody = "";

        switch (requestType.toLowerCase()) {
            case "country":
                if (params.length != 1) {
                    throw new IllegalArgumentException("Invalid number of parameters for 'country' request");
                }
                jsonBody = "{\"country\": \"" + params[0] + "\"}";
                break;

            case "stateandcountry":
                if (params.length != 2) {
                    throw new IllegalArgumentException("Invalid number of parameters for 'stateandcountry' request");
                }
                jsonBody = String.format("{\"country\": \"%s\", \"state\": \"%s\"}", params[0], params[1]);
                break;

            case "city":
                if (params.length != 1) {
                    throw new IllegalArgumentException("Invalid number of parameters for 'city' request");
                }
                jsonBody = String.format("{\"city\": \"%s\"}", params[0]);
                break;

            default:
                throw new IllegalArgumentException("Invalid request type");
        }

        RequestBody body = RequestBody.create(mediaType, jsonBody);

        Request request = new Request.Builder()
                .url(urlLink)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            log.info("RESPONSE: {}", response);
            assert response.body() != null;
            return response.body().string();
        }
    }


}