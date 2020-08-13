package cn.michael.dao;

import cn.michael.entity.User;

import java.util.List;

public interface UserDao {
    List<User> selectUser();
}
