package com.dongfan.dongfanapi.untils;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/7/21 9:38
 * @Version 1.0
 */
public class WordUtils {
    private static final String FTL_FP = "/templates/"; //模板路径

    private static Configuration configuration = null;
    static{
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");//设置默认的编码
        //读配置文件
//        path = PropertiesUtil.get("FILE_PATH")+"/";

    }

    public static Boolean writeWordReport(String wordFilePath,String wordFileName,String templateFileName, Map<String, Object> beanParams) {
        Writer out = null;
        try {
            configuration.setClassForTemplateLoading(WordUtils.class, FTL_FP);
            Template template = configuration.getTemplate(templateFileName, "UTF-8");

            //获取文件目录，如果不存在则创建
            String filePath = "";
            int index = wordFilePath.lastIndexOf(File.separator);
            if (index != wordFilePath.length() - 1) {
                filePath = wordFilePath + File.separator;
            } else {
                filePath = wordFilePath;
            }
            File file1 = new File(filePath);
            if (!file1.exists()) {
                file1.mkdirs();
            }

            //输出文件
            File file = new File(filePath + wordFileName);
            FileOutputStream fos = new FileOutputStream(file);
            out = new OutputStreamWriter(fos, "UTF-8");
            template.process(beanParams, out);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
