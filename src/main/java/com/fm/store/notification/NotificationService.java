package com.fm.store.notification;

public class NotificationService {

    private final EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendEmailConfirmation() {
        // TODO: add items, quantity, price, total, address to message
        String orderId = "123456";
        String to = "customer@gmail.com";
        String message = String.format("Hi there, your order with number %s is placed. Your products should arrive soon. Have a great day!", orderId);
        emailService.sendEmail(to, "Order confirmation", message);
    }

    public void sendSMSConfirmation(String phoneNumber, String message) {
        System.out.println("/POST /api/1.0/simple/transactional");
        System.out.println(phoneNumber + ": " + message);
    }

}
