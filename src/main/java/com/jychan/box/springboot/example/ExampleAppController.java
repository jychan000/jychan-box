package com.jychan.box.springboot.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * @author Raymond
 * @version 15/12/6 20:20 .
 * @E-mail:415683089@qq.com
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
@Controller
public class ExampleAppController implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("this is CommandLineRunner ...");
    }

    public static void main(String[] args) {
        SpringApplication.run(ExampleAppController.class, args);
    }
}
