package com.iilei.authority.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.iilei.authority.entity.Role_permissions;
import com.iilei.authority.mapper.Role_permissionsMapper;
import com.iilei.authority.service.IRole_permissionsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
@Service
public class Role_permissionsServiceImpl extends ServiceImpl<Role_permissionsMapper, Role_permissions> implements IRole_permissionsService {

    @Override
    public List<Role_permissions> findListByRid(Integer rid) {
        EntityWrapper<Role_permissions> wrapper = new EntityWrapper<>();
        wrapper.eq("rid",rid);
        return selectList(wrapper);
    }
}
