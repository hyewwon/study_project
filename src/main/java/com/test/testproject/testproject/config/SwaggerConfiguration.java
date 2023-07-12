package com.test.testproject.testproject.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
//@EnableSwagger2 --> springfox version
public class SwaggerConfiguration {
        @Bean
        public OpenAPI openAPI(){
                return new OpenAPI()
                        .components(new Components())
                        .info(apiInfo());
        }

        private Info apiInfo(){
                return new Info()
                        .title("test_title")
                        .description("springdoc")
                        .version("1.0.0");
        }



//springfox version
//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.test.testproject.testproject"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("swagger")
//                .description("설명 부분")
//                .version("1.0.0")
//                .build();
//    }

}


/*
 @Configuration
    어노테이션 기반의 환경 구성을 돕는 어노테이션
    IoC Container에게 해당 클래스를 Bean 구성 Class 임을 알려줌

 @Bean
    개발자가 직접 제어가 불가능한 외부 라이브러리 등을 Bean으로 만들 경우에 사용
 */
