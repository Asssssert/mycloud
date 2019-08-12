package com.iilei.authority.controller;

import com.iilei.authority.dto.ResponseData;
import com.iilei.authority.params.account.AccountAdd;
import com.iilei.authority.params.account.AccountUpd;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/account")
public interface AccountController {

//    @GetMapping(value = "/test1")
//    @RequiresPermissions("account:test1")
//    public ResponseData test1();

    @PostMapping(value = "/add")
    public ResponseData add(@RequestBody AccountAdd params);

    @DeleteMapping(value = "/del/{ids}")
    public ResponseData del(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/upd")
    public ResponseData upd(@RequestBody AccountUpd params);

    @PatchMapping(value = "/lock/{ids}")
    public ResponseData lock(@PathVariable(value = "ids") Integer[] ids, Integer lock);

    @GetMapping(value = "/get/{id}")
    public ResponseData getById(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/list")
    public ResponseData listByPage(Integer page, Integer size);

}
