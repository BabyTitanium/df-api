package com.dongfan.dongfanapi.params;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLogin {

    @NotNull
    String username;
    @NotNull
    String password;
}
