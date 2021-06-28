package com.fm.store.catalog;

import com.fm.store.core.catalog.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class InventoryServiceTest {

    Map<String, Integer> db = new HashMap<>();
    InventoryService inventoryService = new InventoryService(db);

    @BeforeEach
    void setUp() {
        db.put("car", 3);
        db.put("phone", 2);
        db.put("tv", 0);
    }

    @Test
    void whenInStock_shouldReturnTrue() {
        boolean actual = inventoryService.inStock("car");

        assertThat(actual).isTrue();
    }

    @Test
    void whenNotInStock_shouldReturnFalse() {
        boolean actual = inventoryService.inStock("tv");

        assertThat(actual).isFalse();
    }

    @Test
    void whenIncreaseStock_shouldBeOk() {
        inventoryService.increaseStock("tv", 1);
        boolean actual = inventoryService.inStock("tv");

        assertThat(actual).isTrue();
    }

    @Test
    void whenDecreaseStock_shouldBeOk() {
        inventoryService.decreaseStock("phone", 2);
        boolean actual = inventoryService.inStock("phone");

        assertThat(actual).isFalse();
    }
}