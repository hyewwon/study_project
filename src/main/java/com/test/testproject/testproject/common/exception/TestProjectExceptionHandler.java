package com.test.testproject.testproject.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //Controller에서 발생한 예외사항을 모두 처리함 --> 예상하지 못하는 예외사항을 동일한 형식으로 예외처리 가능
public class TestProjectExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(TestProjectExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e){
        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info("Advice 내 ExceptionHandler 호출");

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

    @ExceptionHandler(value = TestProjectException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(TestProjectException e){
        HttpHeaders responseHeaders = new HttpHeaders();
        Map<String, String> map = new HashMap<>();
        map.put("error type", e.getHttpStatusType());
        map.put("error code", Integer.toString(e.getHttpStatusCode())); // getHttpStatusCode()가 int type으로 return 되기 때문에 toString 작업
        map.put("message", e.getMessage()); //Throwable Class 의 getMessage()

        return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
    }
}
