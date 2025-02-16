package com.app.OnlineLibrary.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class OpenApiService {

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    public String getBookSummary(String title, String author) {
        // Prepare the OpenAI chat request payload (similar to Node.js example)
        JSONObject requestPayload = new JSONObject();
        requestPayload.put("model", "gpt-4o-mini-audio-preview-2024-12-17");  // You can use gpt-4 or gpt-3.5-turbo
        requestPayload.put("store", true);
        requestPayload.put("messages", new JSONObject[] {
                new JSONObject().put("role", "user")
                        .put("content", "write a haiku about AI")  // Your input message here
        });

        // Set up the RestTemplate and headers
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestPayload.toString(), headers);

        try {
            // Send POST request to OpenAI API
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

            // Return the response body (the result from OpenAI API)
            return response.getBody();
        } catch (HttpClientErrorException e) {
            // Handle the error if the request fails
            return "Error occurred: " + e.getMessage();
        }
    }
}
