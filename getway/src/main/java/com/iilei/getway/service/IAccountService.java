package com.iilei.getway.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.entity.Account;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
public interface IAccountService {

    Account findByUsername(String username);

    void add(AccountAdd params);

    void del(Integer[] ids);

    void upd(AccountUpd params);

    Account findById(Integer id);

    Page<Account> listByPage(Integer page, Integer size);

    void lock(Integer[] ids, Integer lock);
}
