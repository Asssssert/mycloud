package com.iilei.basicsauthority.params.account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
