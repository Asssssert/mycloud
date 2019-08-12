package com.iilei.authority.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.iilei.authority.entity.Permissions;
import com.iilei.authority.mapper.PermissionsMapper;
import com.iilei.authority.service.IPermissionsService;
import org.springframework.stereotype.Service;

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
}
