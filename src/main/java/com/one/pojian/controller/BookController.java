package com.one.pojian.controller;

import com.one.pojian.entity.base.Result;
import com.one.pojian.entity.base.ResultCode;
import com.one.pojian.entity.po.Book;
import com.one.pojian.mapper.BookMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author ：ChatGIS
 * @date ：Created in 2024/4/1 00:26
 * @description：书籍
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookMapper bookMapper;

    @RequestMapping("/getBooks")
    public List<Book> getBooks() {
        return bookMapper.selectList(null);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World - Book Class";
    }

    @RequestMapping("/selectBook")
    public List<Map> selectBook() {
        return bookMapper.selectBook();
    }
    @RequestMapping("/testSuccess")
    public Result testSuccess() {
        return Result.success();
    }
    @RequestMapping("/testFail")
    public Result testFail() {
        return Result.fail(ResultCode.EMPTY_PARAM);
    }
}
