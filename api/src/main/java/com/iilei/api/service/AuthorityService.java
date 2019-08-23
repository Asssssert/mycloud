package com.iilei.api.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.config.AuthorityFallBackFactory;
import com.iilei.api.dto.account.AccountDto;
import com.iilei.api.dto.permission.PermissionsDto;
import com.iilei.api.dto.role.RoleDto;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "basics-authority", fallbackFactory = AuthorityFallBackFactory.class)
public interface AuthorityService {
    /**
     * account
     */

    @GetMapping(value = "/account/get/username")
    AccountDto accountFindByUsername(@RequestParam(value = "username") String username);

    @PostMapping(value = "/account/add")
    boolean accountAdd(@RequestBody AccountAdd params);

    @DeleteMapping(value = "/account/del/{ids}")
    boolean accountDel(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/account/upd")
    boolean accountUpd(@RequestBody AccountUpd params);

    @GetMapping(value = "/account/get/{id}")
    AccountDto accountFindById(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/account/list/page")
    Page<AccountDto> accountListByPage(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size);

    @PatchMapping(value = "/account/lock/{ids}")
    boolean accountLock(@PathVariable(value = "ids") Integer[] ids, @RequestParam(value = "lock") Integer lock);

    /**
     * permission
     */
    @GetMapping(value = "/permission/get/{id}")
    PermissionsDto permissionFindById(@PathVariable(value = "id") Integer id);

    @PostMapping(value = "/permission/add")
    boolean permissionAdd(@RequestBody PermissionAdd params);

    @DeleteMapping(value = "/permission/del/{ids}")
    boolean permissionDel(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/permission/upd")
    boolean permissionUpd(@RequestBody PermissionUpd params);

    @GetMapping(value = "/permission/list/page")
    Page<PermissionsDto> permissionListByPage(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size);

    @GetMapping(value = "/permission/list/page/type")
    Page<PermissionsDto> permissionListByType(@RequestParam(value = "type") Integer type, @RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size);

    @GetMapping(value = "/permission/list/page/pid")
    Page<PermissionsDto> permissionListByPid(@RequestParam(value = "pid") Integer pid, @RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size);

    @GetMapping(value = "/permission/list")
    List<PermissionsDto> permissionListAll();

    @GetMapping(value = "/permission/list/rid")
    List<PermissionsDto> permissionListAllByRid(@RequestParam(value = "rid") Integer rid);

    /**
     * role
     */

    @GetMapping(value = "/role/get/{id}")
    RoleDto roleFindById(@PathVariable(value = "id") Integer id);

    @PostMapping(value = "/role/add")
    boolean roleAdd(@RequestBody RoleAdd params);

    @DeleteMapping(value = "/role/del/{ids}")
    boolean roleDel(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/role/upd")
    boolean roleUpd(@RequestBody RoleUpd params);

    @GetMapping(value = "/role/list/page")
    Page<RoleDto> roleListByPage(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size);

    @GetMapping(value = "/role/list")
    List<RoleDto> roleListAll();

    @GetMapping(value = "/role/list/aid")
    List<RoleDto> roleListAllByAid(@RequestParam(value = "aid") Integer aid);
}
