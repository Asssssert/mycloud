package com.iilei.basicsauthority.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.iilei.api.dto.rolepermission.RolePermissionsDto;
import com.iilei.api.exception.ParamException;
import com.iilei.api.params.role.RoleAddPermission;
import com.iilei.api.utils.BeanValidator;
import com.iilei.api.utils.DataUtils;
import com.iilei.basicsauthority.entity.Permissions;
import com.iilei.basicsauthority.entity.Role_permissions;
import com.iilei.basicsauthority.mapper.PermissionsMapper;
import com.iilei.basicsauthority.mapper.Role_permissionsMapper;
import com.iilei.basicsauthority.service.IRole_permissionsService;
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
public class Role_permissionsServiceImpl extends ServiceImpl<Role_permissionsMapper, Role_permissions> implements IRole_permissionsService {
    @Autowired
    private PermissionsMapper permissionsMapper;

    @Override
    public List<RolePermissionsDto> findListByRid(Integer rid) {
        EntityWrapper<Role_permissions> wrapper = new EntityWrapper<>();
        wrapper.eq("rid", rid);
        List<Role_permissions> rps = selectList(wrapper);
        List<RolePermissionsDto> dtoList = Lists.newArrayList();
        rps.forEach(rp -> {
            RolePermissionsDto dto = DataUtils.copyProperties(rp, new RolePermissionsDto());
            dtoList.add(dto);
        });
        return dtoList;
    }

    @Override
    public void addPermission(RoleAddPermission params) {
        BeanValidator.check(params);
        //校验添加的权限是否存在
        for (Integer rid : params.getPids()) {
            Permissions permissions = permissionsMapper.selectById(rid);
            if (permissions == null) {
                throw new ParamException("ID为：【" + rid + "】的权限不存在");
            }
        }
        //删除所有该用户的权限
        EntityWrapper<Role_permissions> wrapper = new EntityWrapper<>();
        wrapper.eq("rid", params.getRid());
        delete(wrapper);
        //给该用户添加角色
        for (Integer pid : params.getPids()) {
            Role_permissions rolePermissions = new Role_permissions();
            rolePermissions.setPid(pid);
            rolePermissions.setRid(params.getRid());
            rolePermissions.setUpdate_time(new Date());
            rolePermissions.setCreate_time(new Date());
            insert(rolePermissions);
        }
    }

    @Override
    public void delPermissionByRid(Integer rid, Integer[] pids) {
        for (Integer pid : pids) {
            EntityWrapper<Role_permissions> wrapper = new EntityWrapper<>();
            wrapper
                    .eq("pid", pid)
                    .eq("rid", rid);
            delete(wrapper);
        }
    }
}
