package com.iilei.basicsauthority.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.dto.permission.PermissionsDto;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.api.vo.ResponseData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/permission")
public interface PermissionController {

    @GetMapping(value = "/get/{id}")
    PermissionsDto findById(@PathVariable(value = "id") Integer id);

    @PostMapping(value = "/add")
    boolean add(@RequestBody PermissionAdd params);

    @DeleteMapping(value = "/del/{ids}")
    boolean del(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/upd")
    boolean upd(@RequestBody PermissionUpd params);

    @GetMapping(value = "/list/page")
    Page<PermissionsDto> listByPage(Integer page, Integer size);

    @GetMapping(value = "/list/page/type")
    Page<PermissionsDto> listByType(Integer type, Integer page, Integer size);

    @GetMapping(value = "/list/page/pid")
    Page<PermissionsDto> listByPid(Integer pid, Integer page, Integer size);

    @GetMapping(value = "/list")
    List<PermissionsDto> listAll();

    @GetMapping(value = "/list/rid")
    List<PermissionsDto> listAllByRid(Integer rid);
}
