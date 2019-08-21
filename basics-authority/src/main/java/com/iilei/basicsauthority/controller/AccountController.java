package com.iilei.basicsauthority.controller;

import com.iilei.basicsauthority.params.account.AccountAdd;
import com.iilei.basicsauthority.params.account.AccountUpd;
import com.iilei.basicsauthority.vo.ResponseData;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/account")
public interface AccountController {

    @GetMapping(value = "/get/username")
    ResponseData findByUsername(String username);

    @PostMapping(value = "/add")
    ResponseData add(@RequestBody AccountAdd params);

    @DeleteMapping(value = "/del/{ids}")
    ResponseData del(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/upd")
    ResponseData upd(@RequestBody AccountUpd params);

    @GetMapping(value = "/get/{id}")
    ResponseData findById(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/list/page")
    ResponseData listByPage(Integer page, Integer size);

    @PatchMapping(value = "/lock/{ids}")
    ResponseData lock(@PathVariable(value = "ids") Integer[] ids, Integer lock);
}
