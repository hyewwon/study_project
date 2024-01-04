package com.test.testproject.testproject.data.entity;

import com.test.testproject.testproject.data.dto.ProductDto;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity // 해당 어노테이션이 적용된 클래스는 JPA가 엔티티로 인식하며 테이블과 링크될 클래스일음 나타넴
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product") // entity 기반 테이블 자동생성 ---> table 명 설정
public class ProductEntity {
    @Id
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;

//    @Column
//    String productId;

    public ProductDto toDto() {
        return ProductDto.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }

}
