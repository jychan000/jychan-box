package com.jychan.box.springboot.example;

import com.jychan.box.springboot.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Raymond
 * @version 15/12/7 13:22
 * @E-mail:415683089@qq.com
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
@Controller
public class HelloExample {

    @Autowired
    private UserService userService;

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        System.out.println(">>>>>>");
        return userService.findAll().toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloExample.class, args);
    }
}
