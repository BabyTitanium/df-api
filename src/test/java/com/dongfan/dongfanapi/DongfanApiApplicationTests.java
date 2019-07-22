package com.dongfan.dongfanapi;

import com.dongfan.dongfanapi.mapper.TikuXiyiQuestionMapper;
import com.dongfan.dongfanapi.untils.WordUtils;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DongfanApiApplicationTests {
    @Resource
    private TikuXiyiQuestionMapper tikuXiyiQuestionMapper;
    Logger logger=LoggerFactory.getLogger(this.getClass());

    @Test
    public void contextLoads() {
    }
    @Test
    public void exportQuestionWord() throws IOException, TemplateException {
        int limit=500;
        int count=tikuXiyiQuestionMapper.getXiyiTiKuQuestionCount();
        int flag=count/limit;
        int next=count%limit;
        int num1=0;
        int num2=0;
        for(int i=0;i<=flag&&next>0;i++){
            int start=i*limit;
            num1=start+1;
            if(i==flag){
                num2=start+next;
            }else{
                num2=start+limit;
            }
            List<Map<String,Object>> list=tikuXiyiQuestionMapper.getXiyiTiKuQuestion(start,limit);
            Map<String,Object> root=new HashMap<>();
            root.put("questionList",list);
            System.out.println(list);
            WordUtils.writeWordReport("D://西医题库","西医"+String.valueOf(num1)+"-"+String.valueOf(num2)+".docx","questionTemplate.ftl",root );
        }



    }

}
