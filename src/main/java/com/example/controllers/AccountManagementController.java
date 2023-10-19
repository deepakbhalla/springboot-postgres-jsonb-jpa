package com.example.controllers;

import com.example.constant.AccountConstants;
import com.example.exception.BadRequestException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Account;
import com.example.model.DeleteAccount;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Account transaction controller.
 */
@RestController
@RequestMapping("/account")
public class AccountManagementController {

    @Autowired
    AccountService accountService;

    /**
     * Create new account.
     *
     * @param account - Account - Account to be created
     * @return Account - Created account
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Account createAccount(@RequestBody Account account) throws BadRequestException {
        return this.accountService.createAccount(account);
    }

    /**
     * Get account information.
     *
     * @param accountNumber - Integer - Account number
     * @return Account - Existing account details
     */
    @GetMapping(value = "/{accountNumber}/balance", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public Account getAccountBalance(@PathVariable("accountNumber") String accountNumber) throws ResourceNotFoundException, BadRequestException {
        return this.accountService.getAccountInformation(accountNumber);
    }

    /**
     * Updates branch name of the existing account.
     *
     * @param accountNumber - Integer - Existing account number
     * @param newBranch     - String - Name of new branch
     * @return Account - Updated account details
     */
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public Account updateAccountBranch(@RequestParam("accountNumber") String accountNumber,
                                       @RequestParam("newBranch") String newBranch) throws ResourceNotFoundException, BadRequestException {
        return this.accountService.updateAccountBranch(accountNumber, newBranch);
    }

    /**
     * Delete an account.
     *
     * @param accountNumber - Integer - Existing account number
     * @return DeleteAccount - Delete account status
     */
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public ResponseEntity<DeleteAccount> deleteAccount(@RequestParam("accountNumber") String accountNumber) throws ResourceNotFoundException, BadRequestException {
        this.accountService.deleteAccount(accountNumber);
        return new ResponseEntity<>(DeleteAccount.builder()
                .timestamp(LocalDateTime.now())
                .accountNumber(Integer.parseInt(accountNumber))
                .status(AccountConstants.DELETED.getMessage())
                .build(), HttpStatus.OK);
    }
}
