package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.resource.RequestAmount;
import com.example.resource.ResponseAmount;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    // 課題１
    public Account open(RequestAmount requestAmount) {
    	Account account = new Account(); // Accountインスタンスを生成
    	account.setAmount(requestAmount.getAmount());
        return this.accountRepository.save(account); // Accountインスタンスの内容をデータベースに登録
    }
    
    // 課題２
    public ResponseAmount getAmount(Integer accountId) {
        Account account = this.accountRepository.findById(accountId).get();
        //findByIdで取得してきたデータはOptional<Account>型なので.get()で変換する
        ResponseAmount responseAmount = new ResponseAmount();
        responseAmount.setAmount(account.getAmount());
        return responseAmount;
    }
}