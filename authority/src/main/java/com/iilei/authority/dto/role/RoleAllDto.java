package com.iilei.authority.dto.role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoleAllDto {
    private Integer id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 名称
     */
    private String name;
}
