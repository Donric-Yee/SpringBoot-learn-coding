package com.donric.controller;

import com.donric.mapper.UserMapper;
import com.donric.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        return userList;
    }

    @GetMapping("/queryUserByname/{name}")
    public User queryUserByname(@PathVariable("name") String name){
        User user = userMapper.queryUserByname(name);
        return user;

    }

    @GetMapping("/addUser")
    public int addUser(){
        int i = userMapper.addUser(new User("派大星",15));
        return i;

    }


    @GetMapping("/updateUser")
    public int updateUser(){
        int i = userMapper.updateUser(new User("章鱼哥",15));
        return i;
    }

    @GetMapping("/deleteUser/{name}")
    public int deleteUser(@PathVariable("name") String name){
        int i = userMapper.deleteUser(name);
        return i;
    }


}
