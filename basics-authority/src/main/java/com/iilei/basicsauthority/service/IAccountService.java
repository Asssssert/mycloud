package com.iilei.basicsauthority.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.iilei.api.dto.account.AccountDto;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.basicsauthority.entity.Account;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-21
 */
public interface IAccountService extends IService<Account> {
    AccountDto findByUsername(String username);

    void add(AccountAdd params);

    void del(Integer[] ids);

    void upd(AccountUpd params);

    AccountDto findById(Integer id);

    Page<AccountDto> listByPage(Integer page, Integer size);

    void lock(Integer[] ids, Integer lock);
}
