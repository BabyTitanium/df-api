package com.dongfan.dongfanapi.service;

import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/8/10 18:22
 * @Version 1.0
 */

public interface ChapterService {
    List getChapterList(String name,int page,int pageSize);
}
