package com.ccgui.dao;

import com.ccgui.pojo.Employ;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<Employ> getEmployList();

    int addEmployList(Map<String, Object> map);
}
