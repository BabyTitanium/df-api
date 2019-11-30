package com.dongfan.dongfanapi.params;

import com.dongfan.dongfanapi.entity.*;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author: lll
 * @Date: 2019/10/20 15:55
 * @Version 1.0
 */
@Data
public class TikuQuestionInfo {
    @NotNull
    @NotEmpty
    String tiku;
    TikuXiyiQuestionWithBLOBs tikuXiyiQuestion;
    TikuXiyizhiyeQuestionWithBLOBs tikuXiyizhiyeQuestion;
    TikuKouqiangQuestionWithBLOBs tikuKouqiangQuestion;
    TikuZhiyexiyaoshiQuestionWithBLOBs tikuZhiyexiyaoshiQuestion;
    TikuZhiyezhongyaoshiQuestionWithBLOBs tikuZhiyezhongyaoshiQuestion;
    TikuXiyizhiyezhuliQuestionWithBLOBs tikuXiyizhiyezhuliQuestion;
    TikuZhongyizhiyeQuestionWithBLOBs tikuZhongyizhiyeQuestion;
}
