package com.test.testproject.testproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;\

@RestController
public class HelloController {
//    @RequestMapping(value = "/hello", method = RequestMethod.GET) : 구버전
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @PostMapping("log-test")
    public void logTest(){
        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        LOGGER.info("Info Log");
        LOGGER.warn("Warn Log");
        LOGGER.error("Error Log");
        // 로그  설정을 <root level="INFO"> 로 설정 했기 때문에 그 밑의 trace와 debug는 기록되지 않음
    }

    @PostMapping("/exception")
    public void exceptionTest() throws Exception{
        throw new Exception();
    }
    @ExceptionHandler(value = Exception.class) // 우선순위 처리로  @RestControllerAdvice 보다 Controller에서 따로 설정한 곳에서 예외처리 됨
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e){
        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info("Controller 내 ExceptionHandler 호출");
        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
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

