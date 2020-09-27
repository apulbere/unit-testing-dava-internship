package com.ipayment;

public class InterestService {

    /**
     * SI = P * R * T,
     * where P = Principal,
     * R = Rate of Interest,
     * T = time period in years,
     * @param account which holds P, T and R
     * @return SI
     */
    public double calculateEarnedInterest(Account account) {
        if(account.principal() < 0) {
            throw new IllegalArgumentException("cannot accept negative principal into calculation");
        }
        return account.principal() * account.rate() * account.time();
    }
}
