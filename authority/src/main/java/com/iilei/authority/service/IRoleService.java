package com.iilei.authority.service;

import com.baomidou.mybatisplus.service.IService;
import com.iilei.authority.entity.Role;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
public interface IRoleService extends IService<Role> {
    Role findById(Integer id);
}
