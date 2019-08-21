package com.iilei.basicsauthority.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.basicsauthority.entity.Permissions;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/permission")
public interface PermissionController {

    @GetMapping(value = "/get/{id}")
    Permissions findById(@PathVariable(value = "id") Integer id);

    @PostMapping(value = "/add")
    boolean add(@RequestBody PermissionAdd params);

    @DeleteMapping(value = "/del/{ids}")
    boolean del(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/upd")
    boolean upd(@RequestBody PermissionUpd params);

    @GetMapping(value = "/list/page")
    Page<Permissions> listByPage(Integer page, Integer size);

    @GetMapping(value = "/list/page/type")
    Page<Permissions> listByType(Integer type, Integer page, Integer size);

    @GetMapping(value = "/list/page/pid")
    Page<Permissions> listByPid(Integer pid, Integer page, Integer size);

    @GetMapping(value = "/list")
    List<Permissions> listAll();

    @GetMapping(value = "/list/rid")
    List<Permissions> listAllByRid(Integer rid);
}
