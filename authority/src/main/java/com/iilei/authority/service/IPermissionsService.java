package com.iilei.authority.service;

import com.iilei.authority.entity.Permissions;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
public interface IPermissionsService extends IService<Permissions> {
    Permissions findById(Integer id);
}
