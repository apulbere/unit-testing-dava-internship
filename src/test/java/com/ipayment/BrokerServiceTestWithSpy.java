package com.ipayment;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static com.ipayment.AccountType.PREMIUM;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BrokerServiceTestWithSpy {

    BrokerService brokerService = spy(new BrokerService());

    @Test
    void shouldCalculateBrokerFee() {
        List accounts = Stream.generate(() -> new Account(PREMIUM)).limit(10).collect(toList());

        double earnedInterestPerAccount = 45.0;
        doReturn(earnedInterestPerAccount).when(brokerService).calculateFee(any(Account.class));

        double actualFee = brokerService.calculateFee(accounts);

        assertThat(actualFee).isEqualTo(earnedInterestPerAccount * accounts.size());
    }
}
