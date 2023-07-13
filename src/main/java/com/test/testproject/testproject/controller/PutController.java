package com.test.testproject.testproject.controller;

import com.test.testproject.testproject.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    @PutMapping(value = "/member")
    public String putMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map ->{
            sb.append(map.getKey() + ":" + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // key와 value가 정해져 있지만 받아야할 파라미터가 많을 경우 DTO객체를 사용
    @PutMapping(value = "/member1")
    public String putMemberDto1(@RequestBody MemberDTO memberDTO){
        return memberDTO.toString(); // return type: string
    }

    @PutMapping(value = "/member2")
    public MemberDTO postMemberDto2(@RequestBody MemberDTO memberDTO){
        return memberDTO; // return type : json
    }
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDTO> postMemberDto3(@RequestBody MemberDTO memberDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
        // accepted : status 202
        // status 값을 지정 가능 / body return type : json
    }
}

/*
ResponseEntity
    Spring에서 제공하는 클래스 중 HttpEntity라는 클래스를 상속받아 사용하는 클래스
    사용자의 HttpRequest에 대한 응답 데이터를 포함
    포함하는 클래스 : HttpStatus, HttpHeaders, HttpBody
 */