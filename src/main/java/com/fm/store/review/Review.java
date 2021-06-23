package com.fm.store.review;

import java.time.LocalDate;

public class Review {

    private Long id;
    private LocalDate createdAt;
    // 1 - 5
    private Integer value;
    private String message;
    private Long userId;
    private Long productId;

    public Review(Integer value, String message, Long userId, Long productId) {
        this.value = value;
        this.message = message;
        this.createdAt = LocalDate.now();
        this.userId = userId;
        this.productId = productId;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
