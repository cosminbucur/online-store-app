package com.fm.store.notification;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmailServiceTest {

    @Test
    void whenSendEmail_thenOk() {
        EmailService emailService = new EmailService();

        String orderId = "12345";

        emailService.sendEmail(
                "customer@gmail.com",
                "Order confirmation",
                String.format("Hi there, your order with number %s is placed. Your products should arrive soon. Have a great day!", orderId));
    }
}