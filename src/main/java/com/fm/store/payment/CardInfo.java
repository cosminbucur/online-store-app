package com.fm.store.payment;

import java.time.LocalDate;

public class CardInfo {

    private final String cardName;
    private final String cardNumber;
    private final LocalDate expirationDate;
    // not allowed to be stored in db
    private final int cvv;

    public CardInfo(String cardName, String cardNumber, LocalDate expirationDate, int cvv) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public int getCvv() {
        return cvv;
    }
}
