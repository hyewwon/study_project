package com.test.testproject.testproject.controller;

import com.test.testproject.testproject.dto.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import org.slf4j.Logger;
@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map ->{
            sb.append(map.getKey() + ":" + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // key와 value가 정해져 있지만 받아야할 파라미터가 많을 경우 DTO객체를 사용
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDTO memberDTO){
        return memberDTO.toString();
    }

}


/*
@PostMapping
    POST API를 제작하기 위해 사용되는 어노테이션
    @RequestMapping + POST method
    일반적으로 추가하고자 하는 Resource를 http body에 추가하여 서버에 요청
    그렇기 때문에 @RequestBody를 이용하여 Body에 담겨있는 값을 받아야함
 */

/*
Swagger ?
서버로 요청되는 API 리스트를 HTML 화면으로 문서화 하여 테스트 할 수 있는 라이브러리
이 라이브러리는 서버가 가동되면 @RestController를 읽어 API를 분석하여 HTML문서 작성
 */


/*
@RequestBody vs @ModelAttribute
    @ModelAttribure :
                    클라이언트가 보내는 HTTP 파라미터들을 특정 Java Object에 바인딩(맵핑) 하는 것
                    modelattribute?name=req&age=1 같은 Query String 형태 혹은 요청 본문에 삽입되는 Form 형태의 데이터를 처리 --> 파라미터로 전달된 데이터 처리 혹은 form에서 넘어온 데이터 처리

    @RequestBody :
                   클라이언트가 보내는 HTTP 요청 본문(JSON 및 XML 등)을 Java 오브젝트로 변환하는 것 --> request body를 통해 전달된 내용 처리 (ex) ajax의 post, put 요청에서 body에 담겨온 데이터 처리 )
                   HTTP 요청 본문 데이터는 Spring에서 제공하는 HttpMessageConverter를 통해 타입에 맞는 객체로 변환
 */


