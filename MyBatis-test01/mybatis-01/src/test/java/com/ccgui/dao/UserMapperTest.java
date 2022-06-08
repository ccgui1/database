package com.ccgui.dao;

import com.ccgui.pojo.Employ;
import com.ccgui.pojo.EmployTest;
import com.ccgui.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest {
    @Test
    public void getEmploy(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper EmployMapper = session.getMapper(UserMapper.class);
        List<Employ> employs = EmployMapper.getEmployList();
        for (Employ employ : employs){
            System.out.println(employ);
        }
        session.close();
    }

    @Test
    public void addEmploy() throws ParseException {
        SqlSession session = MybatisUtils.getSession();
        UserMapper EmployMapper = session.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        //#{userid},#{userworknu}, #{userworkname}, #{usergender}, #{userage}, #{useridcard}, #{userentrydate}
        for (int i =0 ;i<100;i++) {
            map.put("userid", EmployTest.getId());
            map.put("userworknu", EmployTest.getWorkun());
            map.put("userworkname", EmployTest.getWorkname());
            map.put("usergender", EmployTest.getGender());
            map.put("userage", EmployTest.getAge());
            map.put("useridcard", EmployTest.getIdcard());
            map.put("usercity", EmployTest.getCity());
            map.put("userentrydate", EmployTest.getEntrydate());
            EmployMapper.addEmployList(map);
            session.commit();
        }
        session.close();
    }
}
