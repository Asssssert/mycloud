package com.iilei.api.dto.accountrole;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class AccountRoleDto {

    private Integer id;

    /**
     * 账号ID
     */
    private Integer aid;

    /**
     * 角色ID
     */
    private Integer rid;

    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

    /**
     * 修改时间
     */

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;

}
