package com.iilei.basicsauthority.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.dto.role.RoleDto;
import com.iilei.api.params.role.RoleAdd;
import com.iilei.api.params.role.RoleUpd;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/role")
public interface RoleController {
    @GetMapping(value = "/get/{id}")
    RoleDto findById(@PathVariable(value = "id") Integer id);

    @PostMapping(value = "/add")
    boolean add(@RequestBody RoleAdd params);

    @DeleteMapping(value = "/del/{ids}")
    boolean del(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/upd")
    boolean upd(@RequestBody RoleUpd params);

    @GetMapping(value = "/list/page")
    Page<RoleDto> listByPage(Integer page, Integer size);

    @GetMapping(value = "/list")
    List<RoleDto> listAll();

    @GetMapping(value = "/list/aid")
    List<RoleDto> listAllByAid(Integer aid);
}
