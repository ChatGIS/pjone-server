package com.one.pojian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.one.pojian.entity.po.Author;
import com.one.pojian.entity.po.Saying;

import java.util.*;

public interface AuthorService extends IService<Author> {
    Map getAuthorMap();
    HashMap getAuthorHashMap();
    LinkedHashMap getAuthorLinkedHashMap();
    List<Map> getAuthorArrayListMap();
    LinkedList<Map> getAuthorLinkedListMap();
}
