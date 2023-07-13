package com.test.testproject.testproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloController {
//    @RequestMapping(value = "/hello", method = RequestMethod.GET) : 구버전
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}

/*
@RestController
    @Controller + @ ResponseBody가 결합된 어노테이션
    컨트롤러 클래스 하위 메소드에 @ResponseBody 어노테이션을 붙이지 않아도 문자열과 JSON 등을 전송 가능
    View를 거치지 않고 HTTP ResponseBody에 직접 Retrun값을 담아 보내게 됨

@RequestMapping
    MVC의 핸들러 매핑(Handler Mapping)을 위해서 DefaultAnnotationHandlerMapping을 사용
    DefaultAnnotationHandlerMapping 매핑 정보로 @RequestMapping 어노테이션을 활용
    클래스와 메소드의 RequestMapping을 통해 URL을 매핑하여 경로를 설정하여 해당 메소드에서 처리

    value: url 설정
    method : GET, POST, DELETE, PUT, PATTCH 등
 */

