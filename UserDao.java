package com.example.demo;

import java.util.List;

/**
 * yjli
 * 2019/3/29 13:38
 */
public interface UserDao {
    void saveDemo(User User);

    void removeDemo(Long id);

    void updateDemo(User User);

    User findDemoById(Long id);

    User findDemoByName(String name);

    List<User> findAll();
}
