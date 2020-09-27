package com.ipayment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.ipayment.AccountType.PREMIUM;
import static com.ipayment.AccountType.PREMIUM_PLUS;

@NoArgsConstructor
@AllArgsConstructor
public class BrokerService {

    private double brokerFeePercentage;
    private InterestService interestService;

    public double calculateFee(List<Account> accounts) {
        return accounts.stream()
                .filter(this::isEligibleForBrokerFee)
                .map(this::calculateFee)
                .reduce(.0, Double::sum);
    }

    public boolean isEligibleForBrokerFee(Account account) {
        return PREMIUM.equals(account.type()) || PREMIUM_PLUS.equals(account.type());
    }

    double calculateFee(Account account) {
        return brokerFeePercentage * interestService.calculateEarnedInterest(account);
    }
}
