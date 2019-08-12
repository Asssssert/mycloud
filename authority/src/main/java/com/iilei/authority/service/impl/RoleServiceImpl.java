package com.iilei.authority.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.iilei.authority.dto.role.RoleGetDto;
import com.iilei.authority.dto.role.RoleListDto;
import com.iilei.authority.entity.Role;
import com.iilei.authority.exception.ParamException;
import com.iilei.authority.mapper.RoleMapper;
import com.iilei.authority.params.role.RoleAdd;
import com.iilei.authority.params.role.RoleUpd;
import com.iilei.authority.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public Role findById(Integer id) {
        return selectById(id);
    }

    @Override
    public void add(RoleAdd params) {
        BeanValidator.check(params);
        Role role = DataUtils.copyProperties(params, new Role());
        EntityWrapper<Role> wrapper = new EntityWrapper<>();
        wrapper
                .eq("name", params.getName())
                .or()
                .eq("nickname", params.getNickname())
        ;
        Role one = selectOne(wrapper);
        if (one != null) {
            throw new ParamException("该角色名称已被使用");
        }
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
        DataUtils.copyProperties(params, role);
        role.setUpdate_time(new Date());
        updateAllColumnById(role);
    }

    @Override
    public RoleGetDto getById(Integer id) {
        Role role = checkById(id);
        return DataUtils.copyProperties(role, new RoleGetDto());
    }

    @Override
    public Page<RoleListDto> listByPage(Integer page, Integer size) {
        Page accounts = selectPage(PageUtils.pageSizeCheck(page, size));
        List<Role> records = accounts.getRecords();
        List<RoleListDto> dtoList = Lists.newArrayList();
        records.forEach(account -> {
            RoleListDto dto = DataUtils.copyProperties(account, new RoleListDto());
            dtoList.add(dto);
        });
        accounts.setRecords(dtoList);
        accounts.setTotal(selectCount(null));
        return accounts;
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
