package com.iilei.basicsauthority.params.permission;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PermissionUpd {

    private Integer id;

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
