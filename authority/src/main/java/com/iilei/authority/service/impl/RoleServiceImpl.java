package com.iilei.authority.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.iilei.authority.entity.Role;
import com.iilei.authority.mapper.RoleMapper;
import com.iilei.authority.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public Role findById(Integer id) {
        return selectById(id);
    }
}
