package com.iilei.api.config;

import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.api.service.PermissionService;
import com.iilei.api.vo.ResponseData;
import org.springframework.stereotype.Component;

@Component
public class PermissionServiceHystric implements PermissionService {

    @Override
    public ResponseData findById(Integer id) {
        return ResponseData.fail(20000, "service error");
    }

    @Override
    public ResponseData add(PermissionAdd params) {
        return ResponseData.fail(20000, "service error");
    }

    @Override
    public ResponseData del(Integer[] ids) {
        return ResponseData.fail(20000, "service error");
    }

    @Override
    public ResponseData upd(PermissionUpd params) {
        return ResponseData.fail(20000, "service error");
    }

    @Override
    public ResponseData listByPage(Integer page, Integer size) {
        return ResponseData.fail(20000, "service error");
    }

    @Override
    public ResponseData listByType(Integer type, Integer page, Integer size) {
        return ResponseData.fail(20000, "service error");
    }

    @Override
    public ResponseData listByPid(Integer pid, Integer page, Integer size) {
        return ResponseData.fail(20000, "service error");
    }

    @Override
    public ResponseData listAll() {
        return ResponseData.fail(20000, "service error");
    }

    @Override
    public ResponseData listAllByRid(Integer rid) {
        return ResponseData.fail(20000, "service error");
    }
}
