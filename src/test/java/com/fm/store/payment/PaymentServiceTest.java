package com.fm.store.payment;

import com.fm.store.payment.CardInfo;
import com.fm.store.payment.PaymentService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentServiceTest {

    PaymentService paymentService = new PaymentService();

    @Test
    void whenValidCard_shouldMakePayment() {
        CardInfo cardInfo = new CardInfo("test name", "4440 9674 8418 1607", LocalDate.of(23, 5, 1), 321);
        boolean actual = paymentService.makePayment(cardInfo);

        assertThat(actual).isTrue();
    }

    @Test
    void whenValidCreditCardNumber_shouldReturnTrue() {
        boolean visaCard = paymentService.isValidCreditCardNumber("4440 9674 8418 1607");
        boolean masterCard = paymentService.isValidCreditCardNumber("5592 0406 3986 9428");

        assertThat(visaCard).isTrue();
        assertThat(masterCard).isTrue();
    }

    @Test
    void whenInvalidCreditCardNumber_shouldReturnFalse() {
        boolean actual = paymentService.isValidCreditCardNumber("4440 9674 8418 1606");

        assertThat(actual).isFalse();
    }

    @Test
    void whenValidCVV_shouldReturnTrue() {
        boolean actual = paymentService.isValidCVV(123);

        assertThat(actual).isTrue();
    }

    @Test
    void whenInvalidCVV_shouldReturnFalse() {
        boolean moreThanThree = paymentService.isValidCVV(1234);
        boolean lessThanThree = paymentService.isValidCVV(12);
        boolean empty = paymentService.isValidCVV(0);

        assertThat(moreThanThree).isFalse();
        assertThat(lessThanThree).isFalse();
        assertThat(empty).isFalse();
    }

    @Test
    void whenValidDate_shouldReturnTrue() {
        boolean actual = paymentService.isValidDate("05/23");

        assertThat(actual).isTrue();
    }

    @Test
    void whenInvalidDate_shouldReturnTrue() {
        boolean inThePast = paymentService.isValidDate("05/20");

        assertThat(inThePast).isFalse();
    }

    @Test
    void whenInvalidDate_shouldThrowException() {
        assertThrows(DateTimeParseException.class,
                () -> paymentService.isValidDate("13/23"));
    }

}