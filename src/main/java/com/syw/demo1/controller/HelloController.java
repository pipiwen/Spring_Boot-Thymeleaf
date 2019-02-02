package com.syw.demo1.controller;

import com.syw.demo1.entity.User;
import com.syw.demo1.util.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("demo1")
public class HelloController {

    @RequestMapping("success")
    public String success(Map<String,Object>map){
        map.put("hello","你好");
        map.put("hw","<h1>你好世界</h1>");
        map.put("nameList", Arrays.asList("张三","李四","王五","赵六"));
        return "success";//默认去classpath：下templates文件夹下找资源thymeleaf自动渲染
    }
    @PostMapping("login")
    public String login(User user, Map<String, Object>map){
        if(!StringUtils.isEmpty(user.getUsername())&&"123456".equals(user.getPassword())){
            UserUtil.setCurrentUser(user);
            return "dashboard";
        }else {
            map.put("msg","用户名密码错误");
            return "login";
        }

    }
}
