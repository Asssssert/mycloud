package com.iilei.basicsauthority.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.iilei.api.params.account.AccountAdd;
import com.iilei.api.params.account.AccountUpd;
import com.iilei.basicsauthority.entity.Account;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/account")
public interface AccountController {

    @GetMapping(value = "/get/username")
    Account findByUsername(String username);

    @PostMapping(value = "/add")
    boolean add(@RequestBody AccountAdd params);

    @DeleteMapping(value = "/del/{ids}")
    boolean del(@PathVariable(value = "ids") Integer[] ids);

    @PutMapping(value = "/upd")
    boolean upd(@RequestBody AccountUpd params);

    @GetMapping(value = "/get/{id}")
    Account findById(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/list/page")
    Page<Account> listByPage(Integer page, Integer size);

    @PatchMapping(value = "/lock/{ids}")
    boolean lock(@PathVariable(value = "ids") Integer[] ids, Integer lock);
}
