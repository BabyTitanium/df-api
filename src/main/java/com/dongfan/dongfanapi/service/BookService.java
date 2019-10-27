package com.dongfan.dongfanapi.service;

import com.dongfan.dongfanapi.entity.Book;
import com.dongfan.dongfanapi.entity.BookErrata;
import com.dongfan.dongfanapi.entity.BookErrataWithBLOBs;

import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/8/22 20:25
 * @Version 1.0
 */
public interface BookService {
    void addBook(Book book);
    void deleteBook(int id);
    void updateBook(Book book);
    List<Book> getBookList(int page,int pageSize);


    void addNoSubBookErr(BookErrataWithBLOBs bookErrata);
    void subBookErr(BookErrataWithBLOBs bookErrata);
    void deleteBookErr(int userId,int id);
    List<Map> getUserBookErrInfo(int userId,int page,int pageSize);
    List<Map> getBookErrList(int id,int page,int pageSize);

    List<Map> getAllBookErrList(Map condition);

    void passBookErr(int id);
    void dispassBookErr(int id);
}
