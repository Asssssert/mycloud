package com.iilei.gateway.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.dto.account.AccountDto;
import com.iilei.api.exception.ParamException;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.api.service.AuthorityService;
import com.iilei.gateway.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IAccountServiceImpl implements IAccountService {

    @Autowired
    private AuthorityService authorityService;

    @Override
    public AccountDto findByUsername(String username) {
        AccountDto dto = authorityService.accountFindByUsername(username);
        if (dto == null) {
            throw new ParamException("查无此人");
        }
        return dto;
    }

    @Override
    public boolean add(AccountAdd params) {
        return false;
    }

    @Override
    public boolean del(Integer[] ids) {
        return false;
    }

    @Override
    public boolean upd(AccountUpd params) {
        return false;
    }

    @Override
    public AccountDto findById(Integer id) {
        return null;
    }

    @Override
    public Page<AccountDto> listByPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public boolean lock(Integer[] ids, Integer lock) {
        return false;
    }
}
