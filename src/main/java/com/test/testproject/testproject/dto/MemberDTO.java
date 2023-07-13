package com.test.testproject.testproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    private String name;
    private String email;
    private String organization;

//@Override
//public String toString(){
//    return "MemberDTO (" +
//            "name " + name +
//            ", email " + email +
//            ", organization " + organization;
//}

}

