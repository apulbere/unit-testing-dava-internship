package com.ipayment;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ipayment.AccountType.*;
import static org.assertj.core.api.Assertions.assertThat;

class BrokerServiceParametrizedTest {

    BrokerService brokerService = new BrokerService();

    @ParameterizedTest
    @MethodSource("accountsProvider")
    void shouldVerifyIfAccountIsEligibleForBrokerFee(Account account, boolean isAccountEligible) {
        assertThat(brokerService.isEligibleForBrokerFee(account)).isEqualTo(isAccountEligible);
    }

    private static Stream<Arguments> accountsProvider() {
        return Stream.of(
            Arguments.of(new Account(PREMIUM), true),
            Arguments.of(new Account(PREMIUM_PLUS), true),
            Arguments.of(new Account(BUDGET), false)
        );
    }
}