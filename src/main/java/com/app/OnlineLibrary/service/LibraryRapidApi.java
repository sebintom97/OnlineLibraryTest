package com.app.OnlineLibrary.service;

import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class LibraryRapidApi {

    private static final String API_KEY = "fdfb4fc87amsh1946d91f9c80fbcp1e4eadjsn0ff1576eca88";
    private static final String API_HOST = "hapi-books.p.rapidapi.com";
    private static final String API_URL = "https://hapi-books.p.rapidapi.com/top_authors";

    public String getTopAuthors() {
        try {
            // Build the HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("x-rapidapi-key", API_KEY)
                    .header("x-rapidapi-host", API_HOST)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            // Send the request using HttpClient
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Return the response body (the data from the API)
            return response.body();
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
            return "Error: Unable to fetch top authors.";
        }
    }
}
