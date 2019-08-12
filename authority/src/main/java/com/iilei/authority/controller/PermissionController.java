package com.iilei.authority.controller;

import com.iilei.authority.dto.ResponseData;
import com.iilei.authority.params.permission.PermissionAdd;
import com.iilei.authority.params.permission.PermissionUpd;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/permission")
public interface PermissionController {

    @PostMapping(value = "/add")
    public ResponseData add(@RequestBody PermissionAdd params);

    @DeleteMapping(value = "/del/{ids}")

    public ResponseData del(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/upd")
    public ResponseData upd(@RequestBody PermissionUpd params);

    @GetMapping(value = "/get/{id}")
    public ResponseData getById(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/list")
    public ResponseData listByPage(Integer page, Integer size);
}
