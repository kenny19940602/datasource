package com.kenny.datasource.controller;


import com.kenny.datasource.config.DBContextHolder;
import com.kenny.datasource.entity.User;
import com.kenny.datasource.entity.UserExample;
import com.kenny.datasource.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("insert")
    public void insert(){
        User user = new User();
        user.setAge(11L);
        user.setName("kenny");
        userMapper.insert(user);
    }


    /**
     * 分页查询
     * @return {@link Pagination}
     */
    @RequestMapping(value = "/page.do", method = RequestMethod.GET)
    public void page(HttpServletRequest request) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(DBContextHolder.DATASOURCE_KEY, "192.168.5.233");
        map.put(DBContextHolder.DATASOURCE_DRIVER, "com.mysql.jdbc.Driver");
        map.put(DBContextHolder.DATASOURCE_URL,
                "jdbc:mysql://192.168.5.233:3306/test?characterEncoding=utf8&allowMultiQueries=true&serverTimezone=Asia/Shanghai");
        map.put(DBContextHolder.DATASOURCE_USERNAME, "root");
        map.put(DBContextHolder.DATASOURCE_PASSWORD, "");
        DBContextHolder.setDBType(map);
        System.out.println(userMapper.selectByExample(new UserExample()));

    }

    @RequestMapping(value = "/page1.do", method = RequestMethod.GET)
    public void page1(HttpServletRequest request) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(DBContextHolder.DATASOURCE_KEY, "192.168.5.211");
        map.put(DBContextHolder.DATASOURCE_DRIVER, "com.mysql.jdbc.Driver");
        map.put(DBContextHolder.DATASOURCE_URL,
                "jdbc:mysql://192.168.5.211:3306/test?characterEncoding=utf8&allowMultiQueries=true&serverTimezone=Asia/Shanghai");
        map.put(DBContextHolder.DATASOURCE_USERNAME, "root");
        map.put(DBContextHolder.DATASOURCE_PASSWORD, "root");
        DBContextHolder.setDBType(map);
        System.out.println(userMapper.selectByExample(new UserExample()));


    }


}
