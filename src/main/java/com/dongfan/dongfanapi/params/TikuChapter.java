package com.dongfan.dongfanapi.params;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author: lll
 * @Date: 2019/8/17 21:45
 * @Version 1.0
 */
public class TikuChapter {
    @NotNull
    @NotEmpty
    String name;

}
