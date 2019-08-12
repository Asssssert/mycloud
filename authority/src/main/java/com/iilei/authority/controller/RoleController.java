package com.iilei.authority.controller;

import com.iilei.authority.dto.ResponseData;
import com.iilei.authority.params.role.RoleAdd;
import com.iilei.authority.params.role.RoleUpd;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/role")
public interface RoleController {

    @PostMapping(value = "/add")
    public ResponseData add(@RequestBody RoleAdd params);

    @DeleteMapping(value = "/del/{ids}")
    public ResponseData del(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/upd")
    public ResponseData upd(@RequestBody RoleUpd params);

    @GetMapping(value = "/get/{id}")
    public ResponseData getById(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/list")
    public ResponseData listByPage(Integer page, Integer size);

}
