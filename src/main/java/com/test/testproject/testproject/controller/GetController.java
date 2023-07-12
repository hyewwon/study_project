package com.test.testproject.testproject.controller;

import com.test.testproject.testproject.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    @GetMapping(value = "/name")
    public String getName(){
        return "Haewon";
    }

    // 파라미터를 전달하기 위해 url에 값을 담아 요청하는 방법
    // * 아래 방식은 사용된 {변수}의 이름과 메소드의 매개변수를 일치 시켜야함
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    // 아래 방식은 사용된 {변수}의 이름과 메소드의 매개변수가 다를 경우 사용하는 방식
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    // 쿼리 문자열을 전달 방식
    //~~?name=kim&email=email.com ...
    @GetMapping(value = "/request1")
    public String getRequestParam1(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization
    ){
        return name + " " + email + organization;
    }

    // 쿼리 문자열 전달 방식
    // 쿼리 문자열에서 어떤 요청 값이 들어올지 모를 경우 사용
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map ->{
            sb.append(map.getKey() + ":" + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // 쿼리 문자열 전달 방식
    // key 와 value가 정해져있지만 받아야할 파라미터가 많을 경우 DTO 객체를 이용
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        return memberDTO.toString();
    }

}
