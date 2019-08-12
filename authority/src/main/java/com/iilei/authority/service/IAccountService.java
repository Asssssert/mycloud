package com.iilei.authority.service;

import com.baomidou.mybatisplus.service.IService;
import com.iilei.authority.entity.Account;

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
}
