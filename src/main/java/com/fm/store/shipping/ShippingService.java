package com.fm.store.shipping;

import com.fm.store.notification.NotificationService;
import com.fm.store.core.order.Address;
import com.fm.store.core.order.CartItem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ShippingService {

    private final NotificationService notificationService;

    public ShippingService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // TODO: integrate with shippo
    public void shipProducts(List<CartItem> cartItems, Address destination) {
        // customer id
        // customer phone number
        // customer address
        // message

        String orderId = "12345";
        int price = 20;
        LocalDate orderDate = LocalDate.now();
        String deliveryDate = orderDate.plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM"));
        String message = String.format("We got your order %s for %d lei and we will have it delivered on the %s!", orderId, price, deliveryDate);
        notificationService.sendSMSConfirmation("40722333444", message);
    }
}
