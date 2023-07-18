package com.test.testproject.testproject.data.dto;

import com.test.testproject.testproject.data.entity.ProductEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {
    @NotNull // 어노테이션으로 유효성 검증
//    @Size(min = 8, max = 8)
    private String productId;

    @NotNull
    private String productName;

    @NotNull
    @Min(value = 500)
    @Max(value = 30000)
    private int productPrice;

    @NotNull
    @Min(value = 0)
    @Max(value = 999)
    private int productStock;

    public ProductEntity toEntity(){
        return ProductEntity.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }

}
