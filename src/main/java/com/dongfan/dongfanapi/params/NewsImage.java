package com.dongfan.dongfanapi.params;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * @Author: lll
 * @Date: 2019/8/22 19:44
 * @Version 1.0
 */

@Data
public class NewsImage {
    @NotNull
    private MultipartFile multipartFile;
    private String dic;
}
