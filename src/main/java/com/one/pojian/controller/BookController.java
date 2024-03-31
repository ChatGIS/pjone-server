package com.one.pojian.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World - Book Class";
    }
}
