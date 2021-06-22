package com.fm.store.catalog;

import com.fm.store.order.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartService {

    private List<CartItem> items = new ArrayList<>();

    private final InventoryService inventoryService;

    public CartService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void addItem(CartItem cartItem) {
        if (inventoryService.inStock(cartItem.getProduct())) {
            items.add(cartItem);
        } else {
            throw new RuntimeException(cartItem.getProduct() + " not available");
        }
    }

    public void removeItem(CartItem cartItem) {
        items.remove(cartItem);
    }

    public List<CartItem> viewItems() {
        System.out.println(items);
        return items;
    }

    public void clearCart() {
        items.clear();
    }

    public double sum() {
        return items.stream().mapToDouble(CartItem::getTotal).sum();
    }

    public int countItems() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
