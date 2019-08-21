package com.iilei.basicsauthority.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.iilei.basicsauthority.entity.Role;
import com.iilei.basicsauthority.params.role.RoleAdd;
import com.iilei.basicsauthority.params.role.RoleUpd;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-21
 */
public interface IRoleService extends IService<Role> {
    Role findById(Integer id);

    void add(RoleAdd params);

    void del(Integer[] ids);

    void upd(RoleUpd params);

    Page<Role> listByPage(Integer page, Integer size);

    List<Role> listAll();

    List<Role> listAllByAid(Integer aid);
}
