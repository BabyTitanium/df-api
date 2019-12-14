package com.dongfan.dongfanapi.params;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author: lll
 * @Date: 2019/12/14 20:48
 * @Version 1.0
 */

@Data
public class UserRoles {
    @NotNull

    int userId;
    @NotNull
    @NotEmpty
    String roleIds;
}
