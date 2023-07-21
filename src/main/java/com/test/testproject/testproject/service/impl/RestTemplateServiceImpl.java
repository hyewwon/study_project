package com.test.testproject.testproject.service.impl;

import com.test.testproject.testproject.dto.MemberDTO;
import com.test.testproject.testproject.service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {
    private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

    @Override
    public String getTest() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:2424")
                .path("/api/server/test")
                .encode()
                .build() // uri component 로 리턴이 되게 때문에
                .toUri(); // --> toUri로 변환

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public String getName() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:2424")
                .path("/api/server/name")
                .queryParam("name", "flature") // key value 형식으로 데이터 전달
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public String getName2() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:2424")
                .path("/api/server/path-variable/{name}")
                .queryParam("name", "flature") // key value 형식으로 데이터 전달
                .encode()
                .build()
                .expand("flature") // uri의  variable값을 넣을 때 사용 / 복수 값을 넣어야할 경우 ,를 추가
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public ResponseEntity<MemberDTO> postDto() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:2424")
                .path("/api/server/member")
                .queryParam("name", "flature")
                .queryParam("email", "testemail")
                .queryParam("organization", "developer")
                .encode()
                .build()
                .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("flature");
        memberDTO.setEmail("testemail");
        memberDTO.setOrganization("developer");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.postForEntity(uri,memberDTO, MemberDTO.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }

    @Override
    public ResponseEntity<MemberDTO> addHeader() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:2424")
                .path("/api/server/add-header")
                .encode()
                .build()
                .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("flature");
        memberDTO.setEmail("testemail");
        memberDTO.setOrganization("developer");

        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<MemberDTO> requestEntity = RequestEntity
                .post(uri)
                .header("test-header", "TestProject")
                .body(memberDTO);

        ResponseEntity<MemberDTO> responseEntity = restTemplate.exchange(requestEntity, MemberDTO.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }
}
