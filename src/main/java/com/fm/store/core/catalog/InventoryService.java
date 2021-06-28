package com.fm.store.core.catalog;

import java.util.Map;

public class InventoryService {

    private Map<String, Integer> inventory;

    public InventoryService(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public boolean inStock(String product) {
        return inventory.containsKey(product) && inventory.get(product) > 0;
    }

    public void increaseStock(String product, int quantity) {
        inventory.computeIfPresent(product, (key, value) -> value = value + quantity);
    }

    public void decreaseStock(String product, int quantity) {
        inventory.computeIfPresent(product, (key, value) -> value = value - quantity);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
