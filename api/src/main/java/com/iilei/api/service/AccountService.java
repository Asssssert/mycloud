package com.iilei.api.service;

import com.iilei.api.config.AccountServiceHystric;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.api.vo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "basics-authority", fallback = AccountServiceHystric.class)
@RequestMapping(value = "/account")
public interface AccountService {

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
