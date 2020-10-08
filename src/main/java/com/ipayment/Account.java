package com.ipayment;

import static com.ipayment.AccountType.BUDGET;

public final class Account {
    private final double principal;
    private final double rate;
    private final int time;
    private final AccountType type;

    public Account(double principal, double rate, int time) {
        this(principal, rate, time, BUDGET);
    }

    public Account(AccountType type) {
        this(.0, .0, 0, type);
    }

    public Account(double principal, double rate, int time, AccountType type) {
        this.principal = principal;
        this.rate = rate;
        this.time = time;
        this.type = type;
    }

    public double principal() {
        return this.principal;
    }

    public double rate() {
        return this.rate;
    }

    public int time() {
        return this.time;
    }

    public AccountType type() {
        return this.type;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Account)) return false;
        final Account other = (Account) o;
        if (Double.compare(this.principal(), other.principal()) != 0) return false;
        if (Double.compare(this.rate(), other.rate()) != 0) return false;
        if (this.time() != other.time()) return false;
        final Object this$type = this.type();
        final Object other$type = other.type();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $principal = Double.doubleToLongBits(this.principal());
        result = result * PRIME + (int) ($principal >>> 32 ^ $principal);
        final long $rate = Double.doubleToLongBits(this.rate());
        result = result * PRIME + (int) ($rate >>> 32 ^ $rate);
        result = result * PRIME + this.time();
        final Object $type = this.type();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        return result;
    }

    public String toString() {
        return "Account(principal=" + this.principal() + ", rate=" + this.rate() + ", time=" + this.time() + ", type=" + this.type() + ")";
    }
}
