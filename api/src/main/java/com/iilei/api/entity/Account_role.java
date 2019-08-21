package com.iilei.api.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
@Getter
@Setter
@ToString
public class Account_role {

    private Integer id;

    /**
     * 账号ID
     */
    private Integer aid;

    /**
     * 角色ID
     */
    private Integer rid;

    private Date create_time;

    private Date update_time;

}
