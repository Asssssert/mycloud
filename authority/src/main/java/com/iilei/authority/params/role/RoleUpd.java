package com.iilei.authority.params.role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class RoleUpd {
    private Integer id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 名称
     */
    private String name;

    private Date update_time;

}
