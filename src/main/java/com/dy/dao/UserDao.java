/**
 * Created by shaoyongkai on 2017/6/21.
 */

package com.dy.dao;

import java.util.List;

import com.dy.entity.User;


public interface UserDao {

    public void insert(User user);

    public User findUserById(int userId);

    public List<User> findAllUsers();

}
