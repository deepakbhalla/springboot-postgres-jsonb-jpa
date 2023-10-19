package com.example.deserializer;

import com.example.entity.AccountEntity;
import com.example.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailsDeserializer {

    public Account deserializeAccount(AccountEntity accountEntity) {
        return Account.builder()
                .accountNumber(accountEntity.getAccNo())
                .accountHolderName(accountEntity.getHolderName())
                .accountStartDate(accountEntity.getStartDate())
                .accountBranch(accountEntity.getBranch())
                .accountBalance(accountEntity.getBalance())
                .accountTransactions(accountEntity.getTransactions())
                .build();
    }
}
