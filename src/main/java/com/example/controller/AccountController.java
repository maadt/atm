package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.resource.RequestAmount;
import com.example.resource.ResponseAmount;
import com.example.service.AccountService;

@RestController
@RequestMapping(value = "/bankTrading", produces="application/json;charset=UTF-8")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    // 課題１
    @PostMapping("/open")
    public Account open(@RequestBody RequestAmount requestAmount) {
    // @RequestBody：HTTPリクエストのボディをJavaオブジェクトに自動的にマッピングする
        return this.accountService.open(requestAmount);
    }
    
    // 課題２
    @GetMapping("/{account_id}")
    public ResponseAmount getAmount(@PathVariable("account_id") Integer accountId) {
    // @PathVariable：「bankTrading/{account_id}」に対してGETマッピングをするため
    	return this.accountService.getAmount(accountId);
    }
    
    // 課題３
    @PostMapping("/deposit/{account_id}")
    public ResponseAmount deposit(@PathVariable("account_id") Integer accountId, @RequestBody RequestAmount requestAmount) {
        return this.accountService.deposit(accountId, requestAmount);
    }
    
    // 課題４
    @PostMapping("/withdraw/{account_id}")
    public ResponseAmount withdraw(@PathVariable("account_id") Integer accountId, @RequestBody RequestAmount requestAmount) {
        return this.accountService.withdraw(accountId, requestAmount);
    }
}