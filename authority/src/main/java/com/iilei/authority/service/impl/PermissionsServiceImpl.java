package com.iilei.authority.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.iilei.authority.dto.permission.PermissionGetDto;
import com.iilei.authority.dto.permission.PermissionListDto;
import com.iilei.authority.entity.Permissions;
import com.iilei.authority.exception.ParamException;
import com.iilei.authority.mapper.PermissionsMapper;
import com.iilei.authority.params.permission.PermissionAdd;
import com.iilei.authority.params.permission.PermissionUpd;
import com.iilei.authority.service.IPermissionsService;
import com.iilei.authority.utils.BeanValidator;
import com.iilei.authority.utils.DataUtils;
import com.iilei.authority.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
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
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions> implements IPermissionsService {

    @Override
    public Permissions findById(Integer id) {
        return selectById(id);
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
        for (Integer id : ids) {
            deleteById(id);
        }
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
    public PermissionGetDto getById(Integer id) {
        Permissions permissions = checkById(id);
        return DataUtils.copyProperties(permissions, new PermissionGetDto());
    }

    @Override
    public Page<PermissionListDto> listByPage(Integer page, Integer size) {
        Page permissionss = selectPage(PageUtils.pageSizeCheck(page, size));
        return getPermissionListDtoPage(permissionss);
    }

    @Override
    public Page<PermissionListDto> listByType(Integer type, Integer page, Integer size) {
        EntityWrapper<Permissions> wr = new EntityWrapper<>();
        wr.eq("type", type);
        Page permissionss = selectPage(PageUtils.pageSizeCheck(page, size), wr);
        return getPermissionListDtoPage(permissionss);
    }

    @Override
    public Page<PermissionListDto> listByPid(Integer pid, Integer page, Integer size) {
        EntityWrapper<Permissions> wr = new EntityWrapper<>();
        wr.eq("parentId", pid);
        Page permissionss = selectPage(PageUtils.pageSizeCheck(page, size), wr);
        return getPermissionListDtoPage(permissionss);
    }

    private Page<PermissionListDto> getPermissionListDtoPage(Page permissionss) {
        List<Permissions> records = permissionss.getRecords();
        List<PermissionListDto> dtoList = Lists.newArrayList();
        records.forEach(account -> {
            PermissionListDto dto = DataUtils.copyProperties(account, new PermissionListDto());
            dtoList.add(dto);
        });
        permissionss.setRecords(dtoList);
        permissionss.setTotal(selectCount(null));
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
