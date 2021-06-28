package com.fm.store.payment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// TODO: integrate with stripe
public class PaymentService {

    public boolean makePayment(CardInfo cardInfo) {
        if (isValidCreditCard(cardInfo)) {
            System.out.println("payment success");
            return true;
        } else {
            System.out.println("payment failed");
            return false;
        }
    }

    public boolean isValidCreditCard(CardInfo cardInfo) {
        return isValidCreditCardNumber(cardInfo.getCardNumber())
                && isValidDate(cardInfo.getExpirationDate().format(DateTimeFormatter.ofPattern("MM/yy")))
                && isValidCVV(cardInfo.getCvv());
    }

    public boolean isValidCVV(Integer cvv) {
        int length = (int) (Math.log10(cvv) + 1);
        return length == 3;
    }

    public boolean isValidDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

        LocalDate localDate = LocalDate.parse("01/" + date, formatter);

        return localDate.isAfter(LocalDate.now());
    }

    /**
     * A credit card’s number must have 13 to 16 digits, it must start with the following digits:
     *      visa cards start from 4
     *      master cards start from 5
     *
     * Luhn Algorithm validates credit card numbers
     *
     * Step 1 − Starting from the right to left we have to double each the digit, if the result of doubling the number
     * is one digit then leave it as it is, else add up the two digit to get an one digit number. (like 22 = 2+2= 4)
     * Step 2 − Starting from right to left of the card number add all the digits at the odd places.
     * Step 3 − Add all the single digit number obtained from Step 1.
     * Step 4 − Add up the results from Step 2 and Step 3.
     * Step 5 − If the result is divisible by 10 then the card number is valid else the number is not valid.
     *
     * @param cardNumber
     * @return
     */
    public boolean isValidCreditCardNumber(String cardNumber) {
        // remove empty spaces inside and at the end
        cardNumber = cardNumber.replaceAll("\\s","").trim();
        var digits = new int[cardNumber.length()];

        for (var i = 0; i < cardNumber.length(); i++) {
            digits[i] = Integer.parseInt(cardNumber.substring(i, i + 1));
        }

        for (int i = digits.length - 2; i >= 0; i = i - 2) {
            int j = digits[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            digits[i] = j;
        }

        var sum = 0;
        for (int anInt : digits) {
            sum += anInt;
        }
        if (sum % 10 == 0) {
            System.out.println(cardNumber + " is a valid credit card number");
            return true;
        } else {
            System.out.println(cardNumber + " is an invalid credit card number");
            return false;
        }
    }
}
