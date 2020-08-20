package com.donric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询数据库的所有信息
    // 没有实体类，数据库中的东西，怎么获取？ Map
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;

    }

    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into user(name,age) values('以达个',34)";
        jdbcTemplate.update(sql);
        return "insert_ok";
    }

    @RequestMapping("/updateUser/{name}")
    public String updateUser(@PathVariable("name") String name){
        System.out.println(name);
        String sql = "update user set name =?,age=? where name="+"'"+name+"'";
        Object[] objects = new Object[2];
        objects[0] = "海绵";
        objects[1] = "234";
        jdbcTemplate.update(sql,objects); // 有许多重载方法，这里就可以使用objects传递参数
        return "update_ok";
    }

    @GetMapping("/deleteUser/{name}")
    public String deleteUser(@PathVariable("name") String name){
        String sql = "delete from user where name="+"'"+name+"'";
        jdbcTemplate.update(sql);
        return "delete_ok";
    }

}
