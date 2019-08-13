package com.iilei.authority.controller;

import com.iilei.authority.dto.ResponseData;
import com.iilei.authority.params.role.RoleAdd;
import com.iilei.authority.params.role.RoleAddPermission;
import com.iilei.authority.params.role.RoleUpd;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/role")
public interface RoleController {

    @PostMapping(value = "/add")
    @RequiresPermissions("role:add")
    public ResponseData add(@RequestBody RoleAdd params);

    @DeleteMapping(value = "/del/{ids}")
    @RequiresPermissions("role:del")
    public ResponseData del(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/upd")
    @RequiresPermissions("role:upd")
    public ResponseData upd(@RequestBody RoleUpd params);

    @GetMapping(value = "/get/{id}")
    @RequiresPermissions("role:get")
    public ResponseData getById(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/list")
    @RequiresPermissions("role:list")
    public ResponseData listByPage(Integer page, Integer size);

    @PostMapping(value = "/add/permission")
    @RequiresPermissions("role:add:permission")
    public ResponseData addPermission(@RequestBody RoleAddPermission params);

    @DeleteMapping(value = "/del/permission/{rid}")
    @RequiresPermissions("role:del:permission")
    public ResponseData delPermissionByRid(@PathVariable(value = "rid") Integer rid, @Param(value = "pids") Integer[] pids);

}
