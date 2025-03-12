package com.prospera.account.service;

import com.prospera.account.repository.AccountRepository;
import com.prospera.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl  {

private final AccountRepository accountRepository;
    private final Random random = new Random();

    @Transactional
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Transactional
    public void generateRandomAccounts() {
        int numberOfAccounts = random.nextInt(101) + 100; // Generates 100-200 accounts

        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < numberOfAccounts; i++) {
            Account account = new Account();
            account.setAccountHolderName("User" + random.nextInt(10000));
            account.setAccountNumber("ACC" + (100000 + random.nextInt(900000)));
            account.setAccountType(random.nextBoolean() ? "SAVINGS" : "CHECKING");
            account.setBalance(BigDecimal.valueOf(random.nextDouble() * 10000).setScale(2, BigDecimal.ROUND_HALF_UP));
            account.setCurrency(random.nextBoolean() ? "USD" : "EUR");
            account.setInterestRate(BigDecimal.valueOf(random.nextDouble() * 5).setScale(2, BigDecimal.ROUND_HALF_UP));
            account.setOverdraftLimit(BigDecimal.valueOf(random.nextBoolean() ? 500 : 0));
            account.setStatus("ACTIVE");
            account.setUpdatedAt(LocalDateTime.now());

            accounts.add(account);
        }

        try {
            accountRepository.saveAll(accounts); // Batch insert
        } catch (Exception e) {
            throw e;
        }
    }
}
