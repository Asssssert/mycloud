package com.iilei.authority.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.iilei.authority.dto.account.AccountGetDto;
import com.iilei.authority.entity.Account;
import com.iilei.authority.params.account.AccountAdd;
import com.iilei.authority.params.account.AccountUpd;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
public interface IAccountService extends IService<Account> {
    Account findByUsername(String username);

    Account login(String username, String password);

    void add(AccountAdd params);

    void del(Integer[] ids);

    void upd(AccountUpd params);

    AccountGetDto findById(Integer id);

    Page<Account> listByPage(Integer page, Integer size);

    void lock(Integer[] ids,Integer lock);

}
