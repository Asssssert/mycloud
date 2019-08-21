package com.iilei.basicsauthority.controller;

import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;
import com.iilei.api.vo.ResponseData;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/role")
public interface RoleController {
    @GetMapping(value = "/get/{id}")
    ResponseData findById(@PathVariable(value = "id") Integer id);

    @PostMapping(value = "/add")
    ResponseData add(@RequestBody RoleAdd params);

    @DeleteMapping(value = "/del/{ids}")
    ResponseData del(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/upd")
    ResponseData upd(@RequestBody RoleUpd params);

    @GetMapping(value = "/list/page")
    ResponseData listByPage(Integer page, Integer size);

    @GetMapping(value = "/list")
    ResponseData listAll();

    @GetMapping(value = "/list/aid")
    ResponseData listAllByAid(Integer aid);
}
