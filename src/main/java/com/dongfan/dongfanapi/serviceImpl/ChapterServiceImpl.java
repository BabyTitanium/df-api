package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.TikuRecord;
import com.dongfan.dongfanapi.entity.TikuXiyiChapter;
import com.dongfan.dongfanapi.entity.TikuXiyizhiyeChapter;
import com.dongfan.dongfanapi.mapper.*;
import com.dongfan.dongfanapi.params.TikuChapterInfo;
import com.dongfan.dongfanapi.service.ChapterService;
import com.dongfan.dongfanapi.untils.PageResult;
import com.dongfan.dongfanapi.untils.PageUtil;
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

    @Resource
    private TikuXiyizhiyeChapterMapper tikuXiyizhiyeChapterMapper;
    @Resource
    private TikuXiyiChapterMapper tikuXiyiChapterMapper;
    @Resource
    private TikuKouqiangChapterMapper tikuKouqiangChapterMapper;
    @Resource
    private TikuXiyizhiyezhuliChapterMapper tikuXiyizhiyezhuliChapterMapper;
    @Resource
    private TikuZhongyizhiyeChapterMapper tikuZhongyizhiyeChapterMapper;
    @Override
    public PageResult getChapterList(String name, Map map) {
        String dataname="tiku_"+name+"_chapter";
        map.put("dataname",dataname);
        PageUtil.pageCondition(map);
        List<Map> list=tikuRecordMapper.getChapterList(map);
        int count=tikuRecordMapper.getChapterListCount(map);
        return  PageUtil.getPageResult(list,count,map);
    }

    @Override
    public void addChapter(TikuChapterInfo tikuChapterInfo) {
        String name=tikuChapterInfo.getTiku();
        if(name.equals("xiyi")){
            tikuXiyiChapterMapper.insertSelective(tikuChapterInfo.getTikuXiyiChapter());
        }else if(name.equals("xiyizhiye")){
            tikuXiyizhiyeChapterMapper.insertSelective(tikuChapterInfo.getTikuXiyizhiyeChapter());
        }else if (name.equals("kouqiang")){
            tikuKouqiangChapterMapper.insertSelective(tikuChapterInfo.getTikuKouqiangChapter());
        }else if (name.equals("xiyizhiyezhuli")){
            tikuXiyizhiyezhuliChapterMapper.insertSelective(tikuChapterInfo.getTikuXizhiyezhuliChapter());
        }else if (name.equals("zhongyizhiye")){
            tikuZhongyizhiyeChapterMapper.insertSelective(tikuChapterInfo.getTikuZhongyizhiyeChapter());
        }
    }

    @Override
    public void editChapter(TikuChapterInfo tikuChapterInfo) {
        String name=tikuChapterInfo.getTiku();
        if(name.equals("xiyi")){
            tikuXiyiChapterMapper.updateByPrimaryKeySelective(tikuChapterInfo.getTikuXiyiChapter());
        }else if(name.equals("xiyizhiye")){
            tikuXiyizhiyeChapterMapper.updateByPrimaryKeySelective(tikuChapterInfo.getTikuXiyizhiyeChapter());
        }else if (name.equals("kouqiang")){
            tikuKouqiangChapterMapper.updateByPrimaryKeySelective(tikuChapterInfo.getTikuKouqiangChapter());
        }else if (name.equals("xiyizhiyezhuli")){
            tikuXiyizhiyezhuliChapterMapper.updateByPrimaryKeySelective(tikuChapterInfo.getTikuXizhiyezhuliChapter());
        }else if (name.equals("zhongyizhiye")){
            tikuZhongyizhiyeChapterMapper.updateByPrimaryKeySelective(tikuChapterInfo.getTikuZhongyizhiyeChapter());
        }
    }
    @Override
    public void deleteChapter(String name,List ids ) {
        String dataname="tiku_"+name+"_chapter";
        tikuXiyiChapterMapper.deleteChapter(dataname,ids);
    }
}
