package com.one.pojian.controller;

import com.one.pojian.entity.base.Result;
import com.one.pojian.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @description：作者
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping("/getAuthorMap")
    public Result getAuthorMap() {
        Map authorMap = authorService.getAuthorMap();
        return Result.success(authorMap);
    }
    @RequestMapping("/getAuthorHashMap")
    public Result getAuthorHashMap() {
        HashMap authorMap = authorService.getAuthorHashMap();
        return Result.success(authorMap);
    }
    @RequestMapping("/getAuthorLinkedHashMap")
    public Result getAuthorLinkedHashMap() {
        LinkedHashMap authorMap = authorService.getAuthorLinkedHashMap();
        return Result.success(authorMap);
    }
    @RequestMapping("/getAuthorArrayListMap")
    public Result getAuthorArrayListMap() {
        List<Map> authorMap = authorService.getAuthorArrayListMap();
        return Result.success(authorMap);
    }
    @RequestMapping("/getAuthorLinkedListMap")
    public Result getAuthorLinkedListMap() {
        LinkedList<Map> authorMap = authorService.getAuthorLinkedListMap();
        return Result.success(authorMap);
    }
}
