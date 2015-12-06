package com.jychan.box.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Raymond
 * @version 15/12/6 20:15
 * @E-mail:415683089@qq.com
 */
@Controller
@EnableAutoConfiguration
public class ExampleWebController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        System.out.println("haha...>>");
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExampleWebController.class, args);
    }
}
