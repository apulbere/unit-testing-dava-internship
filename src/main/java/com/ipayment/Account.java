package com.ipayment;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import static com.ipayment.AccountType.BUDGET;

@Value
@AllArgsConstructor
@Accessors(fluent = true)
public class Account {
    double principal;
    double rate;
    int time;
    AccountType type;

    public Account(double principal, double rate, int time) {
        this(principal, rate, time, BUDGET);
    }

    public Account(AccountType type) {
        this(.0, .0, 0, type);
    }
}
