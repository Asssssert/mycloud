package com.iilei.authority.controller.impl;

import com.iilei.authority.controller.AccountController;
import com.iilei.authority.dto.ResponseData;
import com.iilei.authority.params.account.AccountAdd;
import com.iilei.authority.params.account.AccountUpd;
import com.iilei.authority.service.IAccountService;
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

    @Override
    public ResponseData add(AccountAdd params) {
        try {
            accountService.add(params);
        } catch (Exception e) {
            return ResponseData.fail(20001, e.getMessage());
        }
        return ResponseData.success("添加成功");
    }

    @Override
    public ResponseData del(Integer[] ids) {
        try {
            accountService.del(ids);
        } catch (Exception e) {
            return ResponseData.fail(20002, e.getMessage());
        }
        return ResponseData.success("删除成功");
    }

    @Override
    public ResponseData upd(AccountUpd params) {
        try {
            accountService.upd(params);
        } catch (Exception e) {
            return ResponseData.fail(20004, e.getMessage());
        }
        return ResponseData.success("修改成功");
    }

    @Override
    public ResponseData lock(Integer[] ids, Integer lock) {
        try {
            accountService.lock(ids, lock);
        } catch (Exception e) {
            return ResponseData.fail(20004, e.getMessage());
        }
        return ResponseData.success("操作成功");
    }

    @Override
    public ResponseData getById(Integer id) {
        return ResponseData.success(accountService.findById(id));
    }

    @Override
    public ResponseData listByPage(Integer page, Integer size) {
        return ResponseData.success(accountService.listByPage(page, size));
    }
}
