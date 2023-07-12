package com.test.testproject.testproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TestProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestProjectApplication.class, args);
    }

}


/*
rest api?
REST 아키텍처의 조건을 준수하는 어플리케이션 프로그래밍 인터페이스를 뜻함
일반적으로 REST 아키텍처를 구현하는 웹 서비스를 RESTful하다고 표현

특징 : REST 기반으로 시스템을 문산하여 확장성과 재사용성을 높임 / HTTP표준을 따르고 있어 여러 프로그래밍 언어로 구현 가능
 */


