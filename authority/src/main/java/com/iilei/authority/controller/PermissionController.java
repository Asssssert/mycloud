package com.iilei.authority.controller;

import com.iilei.authority.dto.ResponseData;
import com.iilei.authority.params.permission.PermissionAdd;
import com.iilei.authority.params.permission.PermissionUpd;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/permission")
public interface PermissionController {

    @PostMapping(value = "/add")
    @RequiresPermissions("permission:add")
    public ResponseData add(@RequestBody PermissionAdd params);

    @DeleteMapping(value = "/del/{ids}")
    @RequiresPermissions("permission:del")
    public ResponseData del(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/upd")
    @RequiresPermissions("permission:upd")
    public ResponseData upd(@RequestBody PermissionUpd params);

    @GetMapping(value = "/get/{id}")
    @RequiresPermissions("permission:get")
    public ResponseData getById(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/list")
    @RequiresPermissions("permission:list")
    public ResponseData listByPage(Integer page, Integer size);

    @GetMapping(value = "/list/all")
    @RequiresPermissions("permission:list:all")
    public ResponseData listAll();

    @GetMapping(value = "/list/rid/{rid}")
    @RequiresPermissions("permission:list:rid")
    public ResponseData listAllByRid(@PathVariable(value = "rid") Integer rid);

    @GetMapping(value = "/list/type")
    @RequiresPermissions("permission:list:type")
    public ResponseData listByPageByType(Integer type, Integer page, Integer size);

    @GetMapping(value = "/list/pid")
    @RequiresPermissions("permission:list:pid")
    public ResponseData listByPid(Integer pid, Integer page, Integer size);
}
