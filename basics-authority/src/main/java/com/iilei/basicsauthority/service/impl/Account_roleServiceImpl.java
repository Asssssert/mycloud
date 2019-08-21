package com.iilei.basicsauthority.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.iilei.api.exception.ParamException;
import com.iilei.api.params.account.AccountAddRole;
import com.iilei.api.utils.BeanValidator;
import com.iilei.basicsauthority.entity.Account_role;
import com.iilei.basicsauthority.entity.Role;
import com.iilei.basicsauthority.mapper.Account_roleMapper;
import com.iilei.basicsauthority.mapper.RoleMapper;
import com.iilei.basicsauthority.service.IAccount_roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-21
 */
@Service
public class Account_roleServiceImpl extends ServiceImpl<Account_roleMapper, Account_role> implements IAccount_roleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Account_role> findListByAid(Integer aid) {
        EntityWrapper<Account_role> wrapper = new EntityWrapper<>();
        wrapper.eq("aid", aid);
        return selectList(wrapper);
    }

    @Override
    public void addRole(AccountAddRole params) {
        BeanValidator.check(params);
        //校验添加的角色是否存在
        for (Integer rid : params.getRids()) {
            Role role = roleMapper.selectById(rid);
            if (role == null) {
                throw new ParamException("ID为：【" + rid + "】的角色不存在");
            }
        }
        //删除所有该用户的权限
        EntityWrapper<Account_role> wrapper = new EntityWrapper<>();
        wrapper.eq("aid", params.getAid());
        delete(wrapper);
        //给该用户添加角色
        for (Integer rid : params.getRids()) {
            Account_role accountRole = new Account_role();
            accountRole.setRid(rid);
            accountRole.setAid(params.getAid());
            accountRole.setUpdate_time(new Date());
            accountRole.setCreate_time(new Date());
            insert(accountRole);
        }
    }

    @Override
    public void delRoleByAid(Integer aid, Integer[] rids) {
        for (Integer rid : rids) {
            EntityWrapper<Account_role> wrapper = new EntityWrapper<>();
            wrapper
                    .eq("aid", aid)
                    .eq("rid", rid);
            delete(wrapper);
        }
    }
}
