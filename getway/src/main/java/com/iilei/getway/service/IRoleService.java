package com.iilei.getway.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.entity.Role;
import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
public interface IRoleService {
    Role findById(Integer id);

    void add(RoleAdd params);

    void del(Integer[] ids);

    void upd(RoleUpd params);

    Page<Role> listByPage(Integer page, Integer size);

    List<Role> listAll();

    List<Role> listAllByAid(Integer aid);
}
