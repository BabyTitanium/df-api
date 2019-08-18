package com.dongfan.dongfanapi.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AuthPermission {
    private Integer id;

    @NotEmpty
    @NotNull
    private String code;
    @NotEmpty
    @NotNull
    private String name;

    public AuthPermission(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public AuthPermission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}