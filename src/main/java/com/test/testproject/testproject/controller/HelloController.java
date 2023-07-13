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

/*
Entity(Domain)
    데이터베이스에 쓰일 컬럼과 여러 엔티티 간의 연관관계의 정의
    데이터베이스의 테이블을 하나의 엔티티로 생각해도 무방
    살제 데이터베이스의 테이블과 1:1로 매핑
    이 클래스의 필드는 각 테이블 내부의 컬럼을 의미
 */

/*
Repository
    Entity에 의해 생성된 데이터베이스에 접근하는 메소드를 사용하기 위한 인터페이스
    Service와 DB를 연결하는 고리의 역할을 수행
    데이터베이스에 적용하고자 하는 crud를 정의하는 영역
 */

/*
* DAO (Data Access Object)
*   데이터베이스에 접근하는 객체를 의미 (Persistance layer)
*   Service가 DB에 연결할 수 있게 해주는 역할
*   DB를 사용하여 데이터를 조회하거나 조작하는 기능을 전달
*
* */

/*
* DTO (Data Transfer Object)
*   DTO는 VO(Value Object)로 불리기도 하며, 계층간 데이터 교화을 위한 객체를 의미
*   VO의 경우 Read Only의 개념을 가지고 있음
*
* */