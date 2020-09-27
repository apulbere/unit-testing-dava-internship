package com.ipayment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InterestServiceTest {

    InterestService interestService = new InterestService();

    @Test
    @DisplayName("if you place $1,000 at 12% per annum, the interest is $120 at the end of each and every year")
    void shouldCalculateCorrectlyInterest() {
        var account = new Account(1_000, .12, 1);

        double actualResult = interestService.calculateEarnedInterest(account);

        assertEquals(120, actualResult);
    }

    @Test
    void shouldFailForNegativePrincipal() {
        var account = new Account(-1_000, .12, 1);

        var thrownException = assertThrows(IllegalArgumentException.class,
                () -> interestService.calculateEarnedInterest(account));

        assertEquals("cannot accept negative principal into calculation", thrownException.getMessage());
    }
}