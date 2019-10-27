package com.dongfan.dongfanapi.params;

import com.dongfan.dongfanapi.entity.*;
import lombok.Data;

/**
 * @Author: lll
 * @Date: 2019/10/20 16:51
 * @Version 1.0
 */
@Data
public class TikuChapterInfo {
    String tiku;
    TikuXiyiChapter tikuXiyiChapter;
    TikuXiyizhiyeChapter tikuXiyizhiyeChapter;
    TikuKouqiangChapter tikuKouqiangChapter;
    TikuZhongyizhiyeChapter tikuZhongyizhiyeChapter;
    TikuXiyizhiyezhuliChapter tikuXizhiyezhuliChapter;
}