package com.iilei.basicsauthority.service;

import com.baomidou.mybatisplus.service.IService;
import com.iilei.api.dto.accountrole.AccountRoleDto;
import com.iilei.api.params.account.AccountAddRole;
import com.iilei.basicsauthority.entity.Account_role;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-21
 */
public interface IAccount_roleService extends IService<Account_role> {
    List<AccountRoleDto> findListByAid(Integer aid);

    void addRole(AccountAddRole params);

    void delRoleByAid(Integer aid, Integer[] rids);
}
