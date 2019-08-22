package com.iilei.basicsauthority.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.iilei.api.dto.permission.PermissionsDto;
import com.iilei.api.exception.ParamException;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.api.utils.BeanValidator;
import com.iilei.api.utils.DataUtils;
import com.iilei.api.utils.PageUtils;
import com.iilei.basicsauthority.entity.Permissions;
import com.iilei.basicsauthority.entity.Role_permissions;
import com.iilei.basicsauthority.mapper.PermissionsMapper;
import com.iilei.basicsauthority.mapper.Role_permissionsMapper;
import com.iilei.basicsauthority.service.IPermissionsService;
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
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions> implements IPermissionsService {
    @Autowired
    private Role_permissionsMapper rolePermissionsMapper;

    @Override
    public PermissionsDto findById(Integer id) {
        Permissions permissions = selectById(id);
        PermissionsDto dto = DataUtils.copyProperties(permissions, new PermissionsDto());
        return dto;
    }

    @Override
    public void add(PermissionAdd params) {
        BeanValidator.check(params);
        Permissions permissions = DataUtils.copyProperties(params, new Permissions());
        EntityWrapper<Permissions> wrapper = new EntityWrapper<>();
        wrapper
                .eq("parentId", params.getParentId())
                .eq("name", params.getName())
                .eq("resource", params.getResource())
        ;
        Permissions one = selectOne(wrapper);
        if (one != null) {
            throw new ParamException("该角色名称已被使用");
        }
        permissions.setCreate_time(new Date());
        permissions.setUpdate_time(new Date());
        insert(permissions);
    }

    @Override
    public void del(Integer[] ids) {
        for (Integer id : ids) {
            Permissions permissions = checkById(id);
            if (permissions.getLevel() == 1) {
                throw new ParamException("id为【" + id + "】的用户不能删除");
            }
        }
        List<Integer> delIds = Lists.newArrayList();
        for (Integer id : ids) {
            delIds(delIds, id);
            deleteById(id);
        }
        delIds.forEach(integer -> {
            deleteById(integer);
        });
    }

    private void delIds(List<Integer> delIds, Integer id) {
        EntityWrapper<Permissions> wr = new EntityWrapper<>();
        wr.eq("parentId", id);
        List<Permissions> delList = selectList(wr);
        delList.forEach(permissions -> {
            if (permissions.getType() == 1) {
                delIds(delIds, permissions.getId());
            }
            delIds.add(permissions.getId());
        });
    }

    @Override
    public void upd(PermissionUpd params) {
        BeanValidator.check(params);
        Permissions permissions = checkById(params.getId());
        DataUtils.copyProperties(params, permissions);
        permissions.setUpdate_time(new Date());
        updateAllColumnById(permissions);
    }

    @Override
    public Page<PermissionsDto> listByPage(Integer page, Integer size) {
        Page permissionss = selectPage(PageUtils.pageSizeCheck(page, size));
        return getPermissionListDtoPage(permissionss, null);
    }

    @Override
    public Page<PermissionsDto> listByType(Integer type, Integer page, Integer size) {
        EntityWrapper<Permissions> wr = new EntityWrapper<>();
        wr.eq("type", type);
        Page permissionss = selectPage(PageUtils.pageSizeCheck(page, size), wr);
        return getPermissionListDtoPage(permissionss, wr);
    }

    @Override
    public Page<PermissionsDto> listByPid(Integer pid, Integer page, Integer size) {
        EntityWrapper<Permissions> wr = new EntityWrapper<>();
        wr.eq("parentId", pid);
        Page permissionss = selectPage(PageUtils.pageSizeCheck(page, size), wr);
        return getPermissionListDtoPage(permissionss, wr);
    }

    @Override
    public List<PermissionsDto> listAll() {
        List<Permissions> pers = selectList(null);
        List<PermissionsDto> dtoList = Lists.newArrayList();
        pers.forEach(p -> {
            PermissionsDto dto = DataUtils.copyProperties(p, new PermissionsDto());
            dtoList.add(dto);
        });
        return dtoList;
    }

    @Override
    public List<PermissionsDto> listAllByRid(Integer rid) {
        EntityWrapper<Role_permissions> wrapper = new EntityWrapper<>();
        wrapper.eq("rid", rid);
        List<Role_permissions> ars = rolePermissionsMapper.selectList(wrapper);
        List<PermissionsDto> dtoList = Lists.newArrayList();
        ars.forEach(account_role -> {
            Permissions source = selectById(account_role.getPid());
            PermissionsDto dto = DataUtils.copyProperties(source, new PermissionsDto());
            dtoList.add(dto);
        });
        return dtoList;
    }

    private Page getPermissionListDtoPage(Page permissionss, EntityWrapper wr) {
        List<Permissions> records = permissionss.getRecords();
        List<PermissionsDto> dtoList = Lists.newArrayList();
        records.forEach(p -> {
            PermissionsDto dto = DataUtils.copyProperties(p, new PermissionsDto());
            dtoList.add(dto);
        });
        permissionss.setRecords(dtoList);
        permissionss.setTotal(selectCount(wr));
        return permissionss;
    }

    /**
     * 根据ID校验是否存在
     *
     * @param id
     * @return
     */
    private Permissions checkById(Integer id) {
        Permissions selectById = selectById(id);
        if (selectById == null) {
            throw new ParamException("id为【" + id + "】的权限不存在");
        }
        return selectById;
    }
}
