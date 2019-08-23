package com.iilei.gateway.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.dto.account.AccountDto;
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

    AccountDto findByUsername(String username);

    boolean add(AccountAdd params);

    boolean del(Integer[] ids);

    boolean upd(AccountUpd params);

    AccountDto findById(Integer id);

    Page<AccountDto> listByPage(Integer page, Integer size);

    boolean lock(Integer[] ids, Integer lock);
}
