package com.iilei.authority.controller;

import com.iilei.authority.dto.ResponseData;
import com.iilei.authority.params.account.AccountAdd;
import com.iilei.authority.params.account.AccountAddRole;
import com.iilei.authority.params.account.AccountUpd;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/account")
public interface AccountController {

    @PostMapping(value = "/add")
    @RequiresPermissions("account:add")
    public ResponseData add(@RequestBody AccountAdd params);

    @DeleteMapping(value = "/del/{ids}")
    @RequiresPermissions("account:del")
    public ResponseData del(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/upd")
    @RequiresPermissions("account:upd")
    public ResponseData upd(@RequestBody AccountUpd params);

    @PatchMapping(value = "/lock/{ids}")
    @RequiresPermissions("account:lock")
    public ResponseData lock(@PathVariable(value = "ids") Integer[] ids, @Param(value = "lock") Integer lock);

    @GetMapping(value = "/get/{id}")
    @RequiresPermissions("account:get")
    public ResponseData getById(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/list")
    @RequiresPermissions("account:list")
    public ResponseData listByPage(Integer page, Integer size);

    @PostMapping(value = "/add/role")
    @RequiresPermissions("account:add:role")
    public ResponseData addRole(@RequestBody AccountAddRole params);

    @DeleteMapping(value = "/del/role/{aid}")
    @RequiresPermissions("account:del:role")
    public ResponseData delRole(@PathVariable(value = "aid") Integer aid, @Param(value = "rids") Integer[] rids);


}
