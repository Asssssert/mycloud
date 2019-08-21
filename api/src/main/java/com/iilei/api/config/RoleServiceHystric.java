package com.iilei.api.config;

import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;
import com.iilei.api.service.RoleService;
import com.iilei.api.vo.ResponseData;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceHystric implements RoleService {

    @Override
    public ResponseData findById(Integer id) {
        return ResponseData.fail(30000, "service error");
    }

    @Override
    public ResponseData add(RoleAdd params) {
        return ResponseData.fail(30000, "service error");
    }

    @Override
    public ResponseData del(Integer[] ids) {
        return ResponseData.fail(30000, "service error");
    }

    @Override
    public ResponseData upd(RoleUpd params) {
        return ResponseData.fail(30000, "service error");
    }

    @Override
    public ResponseData listByPage(Integer page, Integer size) {
        return ResponseData.fail(30000, "service error");
    }

    @Override
    public ResponseData listAll() {
        return ResponseData.fail(30000, "service error");
    }

    @Override
    public ResponseData listAllByAid(Integer aid) {
        return ResponseData.fail(30000, "service error");
    }
}
