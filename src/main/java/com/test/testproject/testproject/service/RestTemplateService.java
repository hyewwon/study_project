package com.test.testproject.testproject.service;

import com.test.testproject.testproject.dto.MemberDTO;
import org.springframework.http.ResponseEntity;

public interface RestTemplateService {
    public String getTest();

    public String getName();

    public  String getName2();

    public ResponseEntity<MemberDTO> postDto();

    public ResponseEntity<MemberDTO> addHeader();
}
