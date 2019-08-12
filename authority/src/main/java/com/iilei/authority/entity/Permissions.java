package com.iilei.authority.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author LiLei
 * @since 2019-08-12
 */
@TableName("user_permissions")
public class Permissions extends Model<Permissions> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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

    private Date create_time;

    private Date update_time;

    /**
     * 权限等级
     */
    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Permissions{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", type=" + type +
        ", name=" + name +
        ", resource=" + resource +
        ", method=" + method +
        ", url=" + url +
        ", describes=" + describes +
        ", create_time=" + create_time +
        ", update_time=" + update_time +
        ", level=" + level +
        "}";
    }
}
