package com.iilei.authority.params.account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class AccountLogin {
    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
