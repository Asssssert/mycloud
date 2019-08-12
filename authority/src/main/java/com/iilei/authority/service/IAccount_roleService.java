package com.iilei.authority.service;

import com.baomidou.mybatisplus.service.IService;
import com.iilei.authority.entity.Account_role;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
public interface IAccount_roleService extends IService<Account_role> {
    List<Account_role> findListByAid(Integer aid);
}
