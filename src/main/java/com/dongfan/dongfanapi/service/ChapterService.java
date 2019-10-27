package com.dongfan.dongfanapi.service;

import com.dongfan.dongfanapi.params.TikuChapterInfo;
import com.dongfan.dongfanapi.untils.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/8/10 18:22
 * @Version 1.0
 */

public interface ChapterService {
    PageResult getChapterList(String name, Map map);
    void addChapter(TikuChapterInfo tikuChapterInfo);
    void deleteChapter(String name,List ids);
}
