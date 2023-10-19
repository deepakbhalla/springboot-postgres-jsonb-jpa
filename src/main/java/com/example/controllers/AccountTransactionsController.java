package com.example.controllers;

import com.example.exception.BadRequestException;
import com.example.exception.InsufficientAccountBalanceException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class AccountTransactionsController {

    @Autowired
    AccountService accountService;

    @PutMapping(value = "/deposit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public Account deposit(@RequestParam("accountNumber") String accountNumber,
                           @RequestParam("amount") String depositAmount) throws ResourceNotFoundException, BadRequestException {
        return this.accountService.deposit(accountNumber, depositAmount);
    }

    @PutMapping(value = "/withdraw", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public Account withdraw(@RequestParam("accountNumber") String accountNumber,
                            @RequestParam("amount") String withdrawalAmount) throws ResourceNotFoundException, BadRequestException, InsufficientAccountBalanceException {
        return this.accountService.withdraw(accountNumber, withdrawalAmount);
    }
}
