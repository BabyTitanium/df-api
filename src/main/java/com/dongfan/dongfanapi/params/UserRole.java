package com.dongfan.dongfanapi.params;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author: lll
 * @Date: 2019/12/8 21:32
 * @Version 1.0
 */
@Data
public class UserRole {

    @NotEmpty
    @NotNull
    int user_id;
    @NotEmpty
    @NotNull
    int role_id;
}
