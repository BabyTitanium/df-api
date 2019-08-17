package com.dongfan.dongfanapi.untils;

import java.util.Map;

public class PageUtil {
    public static void changeToPage(Map<String, Object> map) {
        Object pageObj = map.get("page");
        Object sizeObj = map.get("pageSize");
        if (pageObj != null && sizeObj != null) {
            int pagenum = Integer.valueOf(String.valueOf(pageObj));
            int sizeNum = Integer.valueOf(String.valueOf(sizeObj));
            map.put("pageStart", (pagenum - 1) * sizeNum);
            map.put("pageSize", sizeNum);
        }
    }
    public static int getStart(int page, int pageSize) {

        if (page != -1 && pageSize != -1) {

            return (page - 1) * pageSize;
        }
        return -1;
    }
}
