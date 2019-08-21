package com.iilei.basicsauthority.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.api.vo.ResponseData;
import com.iilei.basicsauthority.entity.Permissions;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/permission")
public interface PermissionController {

    @GetMapping(value = "/get/{id}")
    ResponseData findById(@PathVariable(value = "id") Integer id);

    @PostMapping(value = "/add")
    ResponseData add(@RequestBody PermissionAdd params);

    @DeleteMapping(value = "/del/{ids}")
    ResponseData del(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/upd")
    ResponseData upd(@RequestBody PermissionUpd params);

    @GetMapping(value = "/list/page")
    ResponseData listByPage(Integer page, Integer size);

    @GetMapping(value = "/list/page/type")
    ResponseData listByType(Integer type, Integer page, Integer size);

    @GetMapping(value = "/list/page/pid")
    ResponseData listByPid(Integer pid, Integer page, Integer size);

    @GetMapping(value = "/list")
    ResponseData listAll();

    @GetMapping(value = "/list/rid")
    ResponseData listAllByRid(Integer rid);
}
