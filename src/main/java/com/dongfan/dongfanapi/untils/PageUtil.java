package com.dongfan.dongfanapi.untils;

import org.aspectj.weaver.Lint;

import java.util.List;
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

    public static void pageCondition (Map map){
        Object pageObj = map.get("page");
        Object sizeObj = map.get("pageSize");
        if (pageObj != null && sizeObj != null) {
            int pagenum = Integer.valueOf(String.valueOf(pageObj));
            int sizeNum = Integer.valueOf(String.valueOf(sizeObj));
            map.put("pageStart", (pagenum - 1) * sizeNum);
            map.put("pageSize", sizeNum);
        }
    }
    public static PageResult getPageResult(List list, int count, Map map) {
        PageResult pageResult = new PageResult();
        pageResult.setList(list);
        pageResult.setCount(count);
        Object pageObj = map.get("page");
        Object sizeObj = map.get("pageSize");
        if (pageObj != null && sizeObj != null){
            int page = Integer.valueOf(String.valueOf(pageObj));
            int pageSize = Integer.valueOf(String.valueOf(sizeObj));
            pageResult.setPage(page);
            pageResult.setPageSize(pageSize);
        }
        return pageResult;
    }
}
