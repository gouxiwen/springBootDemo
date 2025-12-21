package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot应用主类
 * 
 * @SpringBootApplication 注解标识这是一个SpringBoot应用
 */
@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    // 启动SpringBoot应用
    SpringApplication.run(DemoApplication.class, args);
  }
}
