package com.donric.mapper;

import com.donric.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//
@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserByname(String name);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(String name);

}
