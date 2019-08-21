package com.iilei.api.service;

import com.iilei.api.config.SchedualAuthorityServiceHystric;
import com.iilei.api.entity.Account;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;
import com.iilei.api.vo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "basics-authority")
public interface AuthorityService {
    /**
     * account
     */

    @GetMapping(value = "/account/get/username")
    Account accountFindByUsername(@RequestParam(value = "username") String username);

    @PostMapping(value = "/account/add")
    ResponseData accountAdd(@RequestBody AccountAdd params);

    @DeleteMapping(value = "/account/del/{ids}")
    ResponseData accountDel(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/account/upd")
    ResponseData accountUpd(@RequestBody AccountUpd params);

    @GetMapping(value = "/account/get/{id}")
    ResponseData accountFindById(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/account/list/page")
    ResponseData accountListByPage(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size);

    @PatchMapping(value = "/account/lock/{ids}")
    ResponseData accountLock(@PathVariable(value = "ids") Integer[] ids, @RequestParam(value = "lock") Integer lock);

    /**
     * permission
     */
    @GetMapping(value = "/permission/get/{id}")
    ResponseData permissionFindById(@PathVariable(value = "id") Integer id);

    @PostMapping(value = "/permission/add")
    ResponseData permissionAdd(@RequestBody PermissionAdd params);

    @DeleteMapping(value = "/permission/del/{ids}")
    ResponseData permissionDel(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/permission/upd")
    ResponseData permissionUpd(@RequestBody PermissionUpd params);

    @GetMapping(value = "/permission/list/page")
    ResponseData permissionListByPage(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size);

    @GetMapping(value = "/permission/list/page/type")
    ResponseData permissionListByType(@RequestParam(value = "type") Integer type, @RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size);

    @GetMapping(value = "/permission/list/page/pid")
    ResponseData permissionListByPid(@RequestParam(value = "pid") Integer pid, @RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size);

    @GetMapping(value = "/permission/list")
    ResponseData permissionListAll();

    @GetMapping(value = "/permission/list/rid")
    ResponseData permissionListAllByRid(@RequestParam(value = "rid") Integer rid);

    /**
     * role
     */

    @GetMapping(value = "/role/get/{id}")
    ResponseData roleFindById(@PathVariable(value = "id") Integer id);

    @PostMapping(value = "/role/add")
    ResponseData roleAdd(@RequestBody RoleAdd params);

    @DeleteMapping(value = "/role/del/{ids}")
    ResponseData roleDel(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/role/upd")
    ResponseData roleUpd(@RequestBody RoleUpd params);

    @GetMapping(value = "/role/list/page")
    ResponseData roleListByPage(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size);

    @GetMapping(value = "/role/list")
    ResponseData roleListAll();

    @GetMapping(value = "/role/list/aid")
    ResponseData roleListAllByAid(@RequestParam(value = "aid") Integer aid);
}
