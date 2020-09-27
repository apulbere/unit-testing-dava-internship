package com.ipayment;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.ipayment.AccountType.BUDGET;
import static com.ipayment.AccountType.PREMIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BrokerServiceTest {

    double brokerFee = .0125;
    InterestService interestRateService = mock(InterestService.class);
    BrokerService brokerService = new BrokerService(brokerFee, interestRateService);

    @Test
    void shouldCalculateBrokerFee() {
        var premiumAccount = new Account(PREMIUM);
        var budgetAccount = new Account(BUDGET);

        double premiumAccountInterest = 35.0;
        when(interestRateService.calculateEarnedInterest(premiumAccount))
                .thenReturn(premiumAccountInterest);

        double expectedFee = brokerFee * premiumAccountInterest;

        double actualFee = brokerService.calculateFee(List.of(premiumAccount, budgetAccount));

        assertEquals(expectedFee, actualFee);

        verify(interestRateService, never()).calculateEarnedInterest(budgetAccount);
    }
}