package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping
    public ResponseAmount getAmount(@RequestBody Integer accountId) {
    	return this.accountService.getAmount(accountId);
    }
}