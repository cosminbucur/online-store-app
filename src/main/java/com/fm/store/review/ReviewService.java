package com.fm.store.review;

import com.fm.store.catalog.InventoryService;

public class ReviewService {

    private InventoryService inventoryService;

    public ReviewService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void getReviewCount(Long productId) {
        inventoryService.getInventory();

    }

    public void getReviewScore(Long productId) {

    }

    public void addReview(Review review) {

    }

    public void removeReview(Long id) {

    }
}
