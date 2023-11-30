package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //对应的视频教程
        //https://www.bilibili.com/video/BV1Xu411A7tL
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    }
}
