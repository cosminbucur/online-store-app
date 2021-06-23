package com.fm.store.catalog;

import com.fm.store.order.CartItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CartServiceTest {

    Map<String, Integer> db = new HashMap<>();
    InventoryService inventoryService = new InventoryService(db);
    CartService cartService = new CartService(inventoryService);

    @BeforeEach
    void setUp() {
        db.put("car", 3);
        db.put("phone", 2);
        db.put("tv", 0);
    }

    @Test
    void whenAdd_shouldHave1Item() {
        CartItem cartItem = new CartItem();
        cartService.addItem(cartItem);

        int actual = cartService.countItems();

        assertThat(actual).isOne();
    }

    @Test
    void whenAddUnavailableProduct_shouldThrowException() {
        CartItem cartItem = new CartItem("lamp", 0, 3);

        assertThrows(RuntimeException.class,
                () -> cartService.addItem(cartItem));
    }

    @Test
    void whenRemove_shouldBeEmpty() {
        CartItem cartItem = new CartItem();
        cartService.addItem(cartItem);

        cartService.removeItem(cartItem);
        boolean actual = cartService.isEmpty();

        assertThat(actual).isTrue();
    }

    @Test
    void whenViewItems_shouldReturnList() {
        CartItem cartItem1 = new CartItem();
        CartItem cartItem2 = new CartItem();
        cartService.addItem(cartItem1);
        cartService.addItem(cartItem2);

        List<CartItem> actual = cartService.viewItems();

        assertThat(actual).hasSize(2);
    }

    @Test
    void whenClearCart_shouldBeEmpty() {
        CartItem cartItem1 = new CartItem();
        CartItem cartItem2 = new CartItem();
        cartService.addItem(cartItem1);
        cartService.addItem(cartItem2);

        cartService.clearCart();

        boolean actual = cartService.isEmpty();

        assertThat(actual).isTrue();
    }

    @Test
    void whenCountItems_shouldReturnCount() {
        CartItem cartItem1 = new CartItem();
        CartItem cartItem2 = new CartItem();
        cartService.addItem(cartItem1);
        cartService.addItem(cartItem2);

        int actual = cartService.countItems();

        assertThat(actual).isEqualTo(2);
    }

    @Test
    void whenIsEmpty_shouldReturnTrue() {
        CartItem cartItem = new CartItem();
        cartService.addItem(cartItem);
        cartService.removeItem(cartItem);

        boolean actual = cartService.isEmpty();

        assertThat(actual).isTrue();
    }

    @Test
    void whenSum_shouldReturnTotalPrice() {
        CartItem cartItem1 = new CartItem("car", 2, 4);
        CartItem cartItem2 = new CartItem("phone", 3, 2);
        cartService.addItem(cartItem1);
        cartService.addItem(cartItem2);

        double actual = cartService.sum();

        assertThat(actual).isEqualTo(14);
    }

    @Test
    void whenUpdateItem_shouldReturnTotalPrice() {
        CartItem cartItem1 = new CartItem("car", 2, 4);
        CartItem cartItem2 = new CartItem("phone", 3, 2);
        cartService.addItem(cartItem1);
        cartService.addItem(cartItem2);

        double actual = cartService.sum();

        assertThat(actual).isEqualTo(14);
    }
}