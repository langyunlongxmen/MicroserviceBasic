package com.HY.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
//why should not we just use product model directly?
//ideally, you should not expose your model entities to outside world
//for example, if you add 2 new fields to product class in the future, and those 2 feature is important to businees logic
//but those are not necessary for client.
//so this is a good practice to separate your model entities and also your data transfer objects