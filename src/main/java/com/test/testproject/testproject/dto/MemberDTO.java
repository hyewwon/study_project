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

/*
    Lombok
    반복되는 메소드를 Annotation을 사용하여 자동으로 작성해주는 라이브러리
    일반적으로 VO, DTO, Model. Entity 등의 데이터 클래스에서 주로 사용됨

    -@Getter : get 메소드를 자동으로 생성
    -@Setter : set 메소드를 자동을 생성
    -@NoArgConstructor : 파라미터가 없는 생성자를 생성
    -@AllArgConstructor : 모든 필드 값을 파라미터로 갖는 생성자를 생성
    -@RequiredArgsContructor : 필드 값 중 final 이나 @NotNull인 값을 갖는 생성자를 생성
    -@ToString : toString 메소드를 자동으로 생성해주는 기능 / exclude 속성을 사용하여 특정 필드를 toString에서 제외시킬 수 있음
    -@EqualsAndHashCode : equals, hashCode 메소드를 자동으로 생성 / callSuper 속성을 통해 메소드 생성시 부모 클래스의 필드까지 고려할지 여부 설정 가능
           * equals : 두 객체의 내용이 같은지 동등성을 비교하는 연산자
           * hashCode : 두 객체가 같은 객체인지 동일성을 비교하는 연산자
    -@Data : 위의 모든 기능을 한번에 추가 (비추)
 */

