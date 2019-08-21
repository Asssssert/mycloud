package com.iilei.basicsauthority.controller.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.api.utils.DataUtils;
import com.iilei.api.vo.ResponseData;
import com.iilei.basicsauthority.controller.AccountController;
import com.iilei.basicsauthority.entity.Account;
import com.iilei.basicsauthority.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class AccountControllerImpl implements AccountController {
    @Autowired
    private IAccountService accountService;
    private Account account;
    private Page<Account> list;

    @Override
    public com.iilei.api.entity.Account findByUsername(String username) {
//        try {
//            account = accountService.findByUsername(username);
//        } catch (Exception e) {
//            return ResponseData.fail(10000, e.getMessage());
//        }
//        System.out.println(account);
//        return ResponseData.success(account);
        Account account = accountService.findByUsername(username);
        com.iilei.api.entity.Account a = DataUtils.copyProperties(account, new com.iilei.api.entity.Account());
        return a;
    }

    @Override
    public ResponseData add(AccountAdd params) {
        try {
            accountService.add(params);
        } catch (Exception e) {
            return ResponseData.fail(10001, e.getMessage());
        }
        return ResponseData.success("添加成功");
    }

    @Override
    public ResponseData del(Integer[] ids) {
        try {
            accountService.del(ids);
        } catch (Exception e) {
            return ResponseData.fail(10002, e.getMessage());
        }
        return ResponseData.success("删除成功");
    }

    @Override
    public ResponseData upd(AccountUpd params) {
        try {
            accountService.upd(params);
        } catch (Exception e) {
            return ResponseData.fail(10003, e.getMessage());
        }
        return ResponseData.success("修改成功");
    }

    @Override
    public ResponseData findById(Integer id) {
        try {
            account = accountService.findById(id);
        } catch (Exception e) {
            return ResponseData.fail(10004, e.getMessage());
        }
        return ResponseData.success(account);
    }

    @Override
    public ResponseData listByPage(Integer page, Integer size) {
        try {
            list = accountService.listByPage(page, size);
        } catch (Exception e) {
            return ResponseData.fail(10005, e.getMessage());
        }
        return ResponseData.success(list);
    }

    @Override
    public ResponseData lock(Integer[] ids, Integer lock) {
        try {
            accountService.lock(ids, lock);
        } catch (Exception e) {
            return ResponseData.fail(10006, e.getMessage());
        }
        return ResponseData.success("操作成功");
    }
}
