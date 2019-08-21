package com.iilei.basicsauthority.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.iilei.basicsauthority.entity.Account;
import com.iilei.basicsauthority.params.account.AccountAdd;
import com.iilei.basicsauthority.params.account.AccountUpd;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-21
 */
public interface IAccountService extends IService<Account> {
    Account findByUsername(String username);

    void add(AccountAdd params);

    void del(Integer[] ids);

    void upd(AccountUpd params);

    Account findById(Integer id);

    Page<Account> listByPage(Integer page, Integer size);

    void lock(Integer[] ids, Integer lock);
}
