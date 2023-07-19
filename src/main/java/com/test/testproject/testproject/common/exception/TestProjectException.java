package com.test.testproject.testproject.common.exception;

import com.test.testproject.testproject.common.Constants;
import org.springframework.http.HttpStatus;

public class TestProjectException extends Exception{
    private static final long serialVersionID = 4663380430591151694L; //직렬화를 위해 생성

    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public TestProjectException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message){
        super(exceptionClass.toString() + message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public Constants.ExceptionClass getExceptionClass(){
        return exceptionClass;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

    public String getHttpStatusType(){
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }


}
