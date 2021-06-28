package com.fm.store.notification.sms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fm.store.config.SecretsConfig;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class SmsService {

    public static final String BULKGATE_URL = "https://portal.bulkgate.com/api/1.0/simple/transactional";
    public static final String MOCK_URL = "https://httpbin.org/post";

    private final SecretsConfig secretsConfig;

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public SmsService(SecretsConfig secretsConfig) {
        this.secretsConfig = secretsConfig;
    }

    public SmsResponse sendSMSConfirmation(String phoneNumber, String message) {
        SmsRequest smsRequest = new SmsRequest(
                secretsConfig.getBulkgate().getAppId(),
                secretsConfig.getBulkgate().getAppToken(),
                phoneNumber,
                message
        );

        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(smsRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create(MOCK_URL))
                .header("Content-Type", "application/json")
                .header("Cache-Control", "no-cache")
                .build();

        HttpResponse<String> response;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println(response.body());
                System.out.println("sent to: " + phoneNumber + " the message: " + message);
                return mapper.readValue(response.body(), SmsResponse.class);
            } else {
                System.out.println(response.body());
                return null;
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("failed sending sms to " + phoneNumber);
        }
        return null;
    }
}
