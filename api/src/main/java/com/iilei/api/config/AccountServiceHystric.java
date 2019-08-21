package com.iilei.api.config;

import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.api.service.AccountService;
import com.iilei.api.vo.ResponseData;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceHystric implements AccountService {
    @Override
    public ResponseData findByUsername(String username) {
        return ResponseData.fail(10000, "service error");
    }

    @Override
    public ResponseData add(AccountAdd params) {
        return ResponseData.fail(10000, "service error");
    }

    @Override
    public ResponseData del(Integer[] ids) {
        return ResponseData.fail(10000, "service error");
    }

    @Override
    public ResponseData upd(AccountUpd params) {
        return ResponseData.fail(10000, "service error");
    }

    @Override
    public ResponseData findById(Integer id) {
        return ResponseData.fail(10000, "service error");
    }

    @Override
    public ResponseData listByPage(Integer page, Integer size) {
        return ResponseData.fail(10000, "service error");
    }

    @Override
    public ResponseData lock(Integer[] ids, Integer lock) {
        return ResponseData.fail(10000, "service error");
    }
}
