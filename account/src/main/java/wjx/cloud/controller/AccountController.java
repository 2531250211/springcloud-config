package wjx.cloud.controller;

import entity.AccountEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import wjx.cloud.mapper.AccountDao;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AccountController {
    @Resource
    private AccountDao accountDao;
    @GetMapping("/account")
    public List<AccountEntity> query(){
        System.out.println("111");
        return accountDao.queryAll();
    }
}
