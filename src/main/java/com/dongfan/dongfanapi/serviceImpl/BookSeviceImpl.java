package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.Book;
import com.dongfan.dongfanapi.entity.BookErrata;
import com.dongfan.dongfanapi.entity.BookErrataWithBLOBs;
import com.dongfan.dongfanapi.mapper.BookErrataMapper;
import com.dongfan.dongfanapi.mapper.BookMapper;
import com.dongfan.dongfanapi.service.BookService;
import com.dongfan.dongfanapi.untils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/8/22 20:26
 * @Version 1.0
 */
@Service
public class BookSeviceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;
    @Resource
    private BookErrataMapper bookErrataMapper;

    @Override
    public void addBook(Book book) {
        bookMapper.insertSelective(book);
    }

    @Override
    public void deleteBook(int id) {
        bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public List<Book> getBookList(int page, int pageSize) {
        int pageStart=PageUtil.getStart(page,pageSize);
        return  bookMapper.getBookList(pageStart,pageSize);
    }

    @Override
    public void addNoSubBookErr(BookErrataWithBLOBs bookErrata) {
        bookErrata.setStatus(1);
        bookErrataMapper.insertSelective(bookErrata);
    }

    @Override
    public void subBookErr(BookErrataWithBLOBs bookErrata) {
        bookErrata.setStatus(2);
        bookErrataMapper.updateByPrimaryKeySelective(bookErrata);
    }

    @Override
    public void deleteBookErr(int userId, int id) {
        bookErrataMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> getUserBookErrInfo(int userId, int page, int pageSize) {
        int pageStart=PageUtil.getStart(page,pageSize);
        return bookErrataMapper.getUserBookErrInfo(userId,pageStart,pageSize);
    }

    @Override
    public List<Map> getBookErrList(int id, int page, int pageSize) {
        int pageStart=PageUtil.getStart(page,pageSize);
        return bookErrataMapper.getOneBookErrInfo(id,pageStart,pageSize);
    }
}
