package com.dongfan.dongfanapi.params;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author: lll
 * @Date: 2019/8/20 20:57
 * @Version 1.0
 */
@Data
public class UploadNews {

    @NotEmpty
    @NotNull
    private String title;

    private MultipartFile poster;


    @Range(min = 1)
    @NotNull
    private Integer typeId;

    private Integer sort;

    private String smeta;

    @NotEmpty
    @NotNull
    private String content;


    private String dic;
}
