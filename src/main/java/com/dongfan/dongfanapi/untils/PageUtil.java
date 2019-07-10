package com.dongfan.dongfanapi.untils;

import io.swagger.models.auth.In;

import java.util.Map;

public class PageUtil {
    public static void changeToPage(Map<String,Object> map){
        Object pageObj=map.get("page");
        Object sizeObj=map.get("pageSize");
        if(pageObj!=null&&sizeObj!=null) {
            int pagenum = Integer.valueOf(String.valueOf(pageObj));
            int sizeNum = Integer.valueOf(String.valueOf(sizeObj));
            map.put("pageStart", (pagenum - 1) * sizeNum );
            map.put("pageSize", sizeNum);
        }
    }
}
