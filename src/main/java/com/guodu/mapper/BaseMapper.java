package com.guodu.mapper;

import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
    Integer insert(T t);

    Integer update(T t);

    Integer delete(String id);

    T selectById(String id);

    List<T> selectList(Map<String, Object> map);

    List<Map<String, Object>> selectListAll();

    Page<?> selectPage(Map<String, Object> map);
}
