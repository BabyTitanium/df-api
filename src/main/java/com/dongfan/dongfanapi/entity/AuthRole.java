package com.dongfan.dongfanapi.entity;

import javax.validation.constraints.NotNull;

public class AuthRole {
    private Integer id;

    @NotNull(message = "角色名称不能为空")
    private String name;
    @NotNull@NotNull(message = "角色code不能为空")
    private String code;

    public AuthRole(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public AuthRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}