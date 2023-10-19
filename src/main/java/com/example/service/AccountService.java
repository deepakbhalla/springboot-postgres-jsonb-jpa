package com.example.service;

import com.example.exception.BadRequestException;
import com.example.exception.InsufficientAccountBalanceException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Account;

public interface AccountService {

    public Account getAccountInformation(String accountNumber) throws ResourceNotFoundException, BadRequestException;

    Account createAccount(Account account) throws BadRequestException;

    Account updateAccountBranch(String accountNumber, String newBranch) throws ResourceNotFoundException, BadRequestException;

    void deleteAccount(String accountNumber) throws ResourceNotFoundException, BadRequestException;

    Account deposit(String accountNumber, String depositAmount) throws ResourceNotFoundException, BadRequestException;

    Account withdraw(String accountNumber, String withdrawalAmount) throws ResourceNotFoundException, BadRequestException, InsufficientAccountBalanceException;
}
