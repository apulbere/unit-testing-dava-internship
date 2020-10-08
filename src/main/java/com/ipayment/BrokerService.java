package com.ipayment;

import java.util.List;

import static com.ipayment.AccountType.PREMIUM;
import static com.ipayment.AccountType.PREMIUM_PLUS;

public class BrokerService {

    private double brokerFeePercentage;
    private InterestService interestService;

    public BrokerService(double brokerFeePercentage, InterestService interestService) {
        this.brokerFeePercentage = brokerFeePercentage;
        this.interestService = interestService;
    }

    public BrokerService() {
    }

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
