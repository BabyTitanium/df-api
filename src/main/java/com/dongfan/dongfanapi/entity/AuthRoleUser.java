package com.dongfan.dongfanapi.entity;

public class AuthRoleUser {
    private Integer id;

    private Integer roleId;

    private Integer userId;

    public AuthRoleUser(Integer id, Integer roleId, Integer userId) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
    }

    public AuthRoleUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}