package com.iilei.basicsauthority.params.account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountAddRole {
    private Integer aid;
    private Integer[] rids;
}
