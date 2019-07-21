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
        logger.info(String.valueOf(System.currentTimeMillis()));
        List<Map<String,Object>> list=tikuXiyiQuestionMapper.getXiyiTiKuQuestion();
        logger.info(String.valueOf(System.currentTimeMillis()));
        Map<String,Object> root=new HashMap<>();
        root.put("questionList",list);
        System.out.println(list);
        WordUtils.writeWordReport("D://","allQuestion.docx","questionTemplate.ftl",root );
        logger.info(String.valueOf(System.currentTimeMillis()));

    }

}
