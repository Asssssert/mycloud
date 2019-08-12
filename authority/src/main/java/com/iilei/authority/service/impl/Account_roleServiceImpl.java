package com.iilei.authority.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.iilei.authority.entity.Account_role;
import com.iilei.authority.mapper.Account_roleMapper;
import com.iilei.authority.service.IAccount_roleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
@Service
public class Account_roleServiceImpl extends ServiceImpl<Account_roleMapper, Account_role> implements IAccount_roleService {

    @Override
    public List<Account_role> findListByAid(Integer aid) {
        EntityWrapper<Account_role> wrapper = new EntityWrapper<>();
        wrapper.eq("aid", aid);
        return selectList(wrapper);
    }
}
