package com.fm.store;

import com.fm.store.notification.EmailService;
import com.fm.store.notification.NotificationService;
import com.fm.store.order.Address;
import com.fm.store.payment.CardInfo;
import com.fm.store.order.CartItem;
import com.fm.store.catalog.CartService;
import com.fm.store.catalog.InventoryService;
import com.fm.store.payment.PaymentService;
import com.fm.store.shipping.ShippingService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class AcceptanceTest {

    @Test
    void acceptanceTest() {
        // add products to catalog
        Map<String, Integer> db = new HashMap<>();
        db.put("car", 3);
        db.put("phone", 2);
        db.put("tv", 0);

        InventoryService inventoryService = new InventoryService(db);
        CartService cartService = new CartService(inventoryService);
        PaymentService paymentService = new PaymentService();

        EmailService emailService = new EmailService();
        NotificationService notificationService = new NotificationService(emailService);
        ShippingService shippingService = new ShippingService(notificationService);

        // add products in inventory
        inventoryService.increaseStock("tv", 2);

        // add items to cart
        CartItem cartItem1 = new CartItem("car", 2, 4);
        CartItem cartItem2 = new CartItem("phone", 3, 2);
        cartService.addItem(cartItem1);
        cartService.addItem(cartItem2);
        cartService.viewItems();

        // pay
        CardInfo cardInfo = new CardInfo("test name", "4440 9674 8418 1607", LocalDate.of(23, 5, 1), 321);
        paymentService.makePayment(cardInfo);

        // ship product
        Address address = new Address("022333");
        shippingService.shipProducts(cartService.viewItems(), address);
    }
}
