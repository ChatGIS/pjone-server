package com.one.pojian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.one.pojian.entity.po.Author;
import com.one.pojian.entity.po.Saying;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public interface AuthorService extends IService<Author> {
    Map getAuthorMap();
    HashMap getAuthorHashMap();
    LinkedHashMap getAuthorLinkedHashMap();
}
