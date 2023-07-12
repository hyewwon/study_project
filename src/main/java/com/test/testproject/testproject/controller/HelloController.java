package com.test.testproject.testproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @RequestMapping(value = "/hello", method = RequestMethod.GET) : 구버전
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}

/*
Controller ?
    모델과 뷰 사이에서 브릿지 역할 수행
    앱의 사용자로부터 입력에 대한 응답으로 모델 및 뷰를 업데이트 하는 로직을 포함
    사용자의 요청은 모두 컨트롤러를 통해 진행
    들어온 요청은 모델이 어떻게 처리할지 결정하여 모델로 요청을 전달

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
