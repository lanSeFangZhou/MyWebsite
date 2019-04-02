package com.example.demo;

import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yjli
 * @description
 * @date 2019/3/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyWebsite2Application.class)
public class DemoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void saveDemoTest() {

        User user = new User();
        user.setId(1L);
        user.setName("Spring Boot 中使用 MongoDB");
        user.setPassword("关注公众号，搜云库，专注于开发技术的研究与知识分享");
        user.setRole("souyunku");
        user.setLevel("http://www.souyunku.com");

        userDao.saveDemo(user);

        user = new User();
        user.setId(2L);
        user.setName("Spring Boot 中使用 MongoDB");
        user.setPassword("关注公众号，搜云库，专注于开发技术的研究与知识分享");
        user.setRole("souyunku");
        user.setLevel("http://www.souyunku.com");

        userDao.saveDemo(user);
    }

    @Test
    public void removeDemoTest() {
        userDao.removeDemo(2L);
    }

    @Test
    public void updateDemoTest() {

        User user = new User();
        user.setId(1L);
        user.setName("Spring Boot 中使用 MongoDB 更新数据");
        user.setPassword("关注公众号，搜云库，专注于开发技术的研究与知识分享");
        user.setRole("souyunku");
        user.setLevel("http://www.souyunku.com");

        userDao.updateDemo(user);
    }

    @Test
    public void findDemoByIdTest() {

        User user = userDao.findDemoById(1L);
    }
}
