package com.fm.store.notification;

import com.fm.store.config.PropertiesLoader;
import com.fm.store.config.SecretsConfig;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmailServiceTest {

    @Test
    void whenSendEmail_thenOk() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        EmailService emailService = new EmailService(propertiesLoader.getSecretsConfig());

        String orderId = "12345";

        emailService.sendEmail(
                "customer@gmail.com",
                "Order confirmation",
                String.format("Hi there, your order with number %s is placed. Your products should arrive soon. Have a great day!", orderId));
    }
}