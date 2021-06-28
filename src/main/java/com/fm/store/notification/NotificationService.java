package com.fm.store.notification;

import com.fm.store.notification.sms.SmsService;

public class NotificationService {

    private final EmailService emailService;
    private final SmsService smsService;

    public NotificationService(EmailService emailService, SmsService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void sendEmailConfirmation() {
        // TODO: add items, quantity, price, total, address to message
        String orderId = "123456";
        String to = "customer@gmail.com";
        String message = String.format("Hi there, your order with number %s is placed. Your products should arrive soon. Have a great day!", orderId);
        emailService.sendEmail(to, "Order confirmation", message);
    }

    public void sendSMSConfirmation(String phoneNumber, String message) {
        smsService.sendSMSConfirmation(phoneNumber, message);
    }

}
