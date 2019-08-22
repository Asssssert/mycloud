package com.iilei.basicsauthority.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.iilei.api.dto.role.RoleDto;
import com.iilei.api.exception.ParamException;
import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;
import com.iilei.api.utils.BeanValidator;
import com.iilei.api.utils.DataUtils;
import com.iilei.api.utils.PageUtils;
import com.iilei.basicsauthority.entity.Account_role;
import com.iilei.basicsauthority.entity.Role;
import com.iilei.basicsauthority.mapper.Account_roleMapper;
import com.iilei.basicsauthority.mapper.RoleMapper;
import com.iilei.basicsauthority.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private Account_roleMapper accountRoleMapper;

    @Override
    public RoleDto findById(Integer id) {
        Role role = selectById(id);
        RoleDto dto = DataUtils.copyProperties(role, new RoleDto());
        return dto;

    }

    @Override
    public void add(RoleAdd params) {
        BeanValidator.check(params);
        Role role = DataUtils.copyProperties(params, new Role());
        checkRole(params.getName(), params.getNickname());
        role.setCreate_time(new Date());
        role.setUpdate_time(new Date());
        insert(role);

    }

    @Override
    public void del(Integer[] ids) {
        for (Integer id : ids) {
            Role role = checkById(id);
            if (role.getLevel() == 1) {
                throw new ParamException("id为【" + id + "】的用户不能删除");
            }
        }
        for (Integer id : ids) {
            deleteById(id);
        }
    }

    @Override
    public void upd(RoleUpd params) {
        BeanValidator.check(params);
        Role role = checkById(params.getId());
        checkRole(params.getName(), params.getNickname());
        DataUtils.copyProperties(params, role);
        role.setUpdate_time(new Date());
        updateAllColumnById(role);
    }

    private void checkRole(String name, String nickname) {
        EntityWrapper<Role> wrapper = new EntityWrapper<>();
        wrapper
                .eq("name", name)
                .or()
                .eq("nickname", nickname)
        ;
        Role one = selectOne(wrapper);
        if (one != null) {
            throw new ParamException("该角色名称已被使用");
        }
    }

    @Override
    public Page<RoleDto> listByPage(Integer page, Integer size) {
        Page roles = selectPage(PageUtils.pageSizeCheck(page, size));
        List records = roles.getRecords();
        List<RoleDto> dtoList = Lists.newArrayList();
        records.forEach(role -> {
            RoleDto dto = DataUtils.copyProperties(role, new RoleDto());
            dtoList.add(dto);
        });
        roles.setRecords(dtoList);
        roles.setTotal(selectCount(null));
        return roles;
    }

    @Override
    public List<RoleDto> listAll() {
        List<Role> roles = selectList(null);
        List<RoleDto> dtoList = Lists.newArrayList();
        roles.forEach(role -> {
            RoleDto dto = DataUtils.copyProperties(role, new RoleDto());
            dtoList.add(dto);
        });
        return dtoList;
    }

    @Override
    public List<RoleDto> listAllByAid(Integer aid) {
        EntityWrapper<Account_role> wrapper = new EntityWrapper<>();
        wrapper.eq("aid", aid);
        List<Account_role> ars = accountRoleMapper.selectList(wrapper);
        List<RoleDto> dtoList = Lists.newArrayList();
        ars.forEach(account_role -> {
            Role role = selectById(account_role.getRid());
            RoleDto dto = DataUtils.copyProperties(role, new RoleDto());
            dtoList.add(dto);
        });
        return dtoList;
    }

    /**
     * 根据ID校验是否存在
     *
     * @param id
     * @return
     */
    private Role checkById(Integer id) {
        Role selectById = selectById(id);
        if (selectById == null) {
            throw new ParamException("id为【" + id + "】的角色不存在");
        }
        return selectById;
    }
}
