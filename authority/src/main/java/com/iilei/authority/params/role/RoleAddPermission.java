package com.iilei.authority.params.role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoleAddPermission {
    private Integer rid;
    private Integer[] pids;
}
