package com.example.demo;/**
 * yjli
 * 2019/3/29 9:50
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author yjli
 * @description
 * @date 2019/3/29
 */
@RestController
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/api/login", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public WebResult login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("前端请求成功！");
        String username = request.getParameter("username");
        System.out.println("username:" + username);
        String password = request.getParameter("password");
        System.out.println("password:" + password);
        WebResult result = new WebResult();
        User user = userDao.findDemoByName(username);
        if (user.getPassword().equals(password)) {
            result.setMsg("登录成功");
            result.setCode(200);
        } else {
            result.setMsg("登录失败");
            result.setCode(-1);
        }
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "POST,GET");
        return result;
    }

    @RequestMapping(value = "/api/register", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public WebResult register(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("name");
        Long id = Long.valueOf(request.getParameter("id"));
        String role = request.getParameter("role");
        String level = request.getParameter("level");
        String password = request.getParameter("word");
        User user = new User(id, username, password, role, level);
        WebResult result = new WebResult();
        userDao.saveDemo(user);
        result.setMsg("注册成功");
        result.setCode(200);
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "POST,GET");
        return result;
    }

    @RequestMapping(value = "/api/queryAll", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
    public WebResult queryAll(HttpServletRequest request, HttpServletResponse response) {
        List<User> list = userDao.findAll();
        WebResult result = new WebResult();
        result.setData(list);
        result.setMsg("查询成功");
        result.setCode(200);
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "POST,GET");
        return result;
    }

}
