package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.TikuRecord;
import com.dongfan.dongfanapi.mapper.TikuRecordMapper;
import com.dongfan.dongfanapi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/8/10 18:22
 * @Version 1.0
 */
@Service
public class ChapterServiceImpl  implements ChapterService {
    @Resource
    private TikuRecordMapper tikuRecordMapper;
    @Override
    public List getChapterList(String name) {
        String dataname="tiku_"+name+"_chapter";
        List<Map> list=new ArrayList();
        list=tikuRecordMapper.getChapterList(dataname);
        return  list;
    }
}
