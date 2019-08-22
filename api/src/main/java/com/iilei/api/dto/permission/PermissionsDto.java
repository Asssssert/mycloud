package com.iilei.api.dto.permission;

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
public class PermissionsDto {

    private Integer id;

    /**
     * 父权限ID
     */
    private Integer parentId;

    /**
     * 权限类型  1、分类，2、权限
     */
    private Integer type;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 资源编码
     */
    private String resource;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 备注
     */
    private String describes;

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

    /**
     * 权限等级
     */
    private Integer level;


}
