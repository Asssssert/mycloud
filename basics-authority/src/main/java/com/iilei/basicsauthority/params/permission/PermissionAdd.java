package com.iilei.basicsauthority.params.permission;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PermissionAdd {

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
}
