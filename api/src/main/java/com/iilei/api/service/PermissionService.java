package com.iilei.api.service;

import com.iilei.api.config.PermissionServiceHystric;
import com.iilei.api.params.permission.PermissionAdd;
import com.iilei.api.params.permission.PermissionUpd;
import com.iilei.api.vo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "basics-authority", fallback = PermissionServiceHystric.class)
@RequestMapping(value = "/permission")
public interface PermissionService {

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
