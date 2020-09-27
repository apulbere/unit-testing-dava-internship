package com.ipayment.wrong;

import com.ipayment.Account;
import com.ipayment.AccountType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.ipayment.AccountType.*;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //fast
public class NonIsolatedTest {

    AccountRepository accountRepository = new AccountRepository();

    @Test
    void shouldFindAllPremiumAccounts() {
        var premium = new Account(35_000, .2, 2, PREMIUM);
        var budget = new Account(200, .3, 2, BUDGET);

        accountRepository.save(premium);
        accountRepository.save(budget);

        assertThat(accountRepository.findAllByType(PREMIUM))
                .hasSize(1)
                .containsOnly(premium);
    }

    @Test
    void shouldFindAllWithPrincipalLessThan() {
        var greaterThan600 = new Account(45_000, .05, 4, PREMIUM);
        var lessThan600 = new Account(559, .12, 1, PREMIUM_PLUS);
        accountRepository.save(greaterThan600);
        accountRepository.save(lessThan600);

        assertThat(accountRepository.findAllPrincipalLessThan(600))
                .hasSize(1)
                .containsOnly(lessThan600);
    }

    static class AccountRepository {

        List<Account> accounts = new ArrayList<>();

        void save(Account account) {
            accounts.add(account);
        }

        void dropAll() {
            accounts.clear();
        }

        List<Account> findAllByType(AccountType type) {
            return findBy(account -> type.equals(account.type()));
        }

        List<Account> findAllPrincipalLessThan(double principal) {
            return findBy(account -> account.principal() < principal);
        }

        List<Account> findBy(Predicate<Account> predicate) {
            return accounts.stream()
                    .filter(predicate)
                    .collect(toList());
        }
    }
}
