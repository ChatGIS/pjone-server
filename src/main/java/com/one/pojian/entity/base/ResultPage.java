package com.one.pojian.entity.base;

import lombok.Data;

import java.util.List;

@Data
public class ResultPage<T> {
    private List<T> records;
    private int total;
    private int size;
    private int current;
    private int pages;

    public ResultPage(List<T> records, int total, int size, int current, int pages) {
        this.records = records;
        this.total = total;
        this.size = size;
        this.current = current;
        this.pages = pages;
    }
}
