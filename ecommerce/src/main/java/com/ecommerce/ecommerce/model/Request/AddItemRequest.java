package com.ecommerce.ecommerce.model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddItemRequest {
    private Long id;
    private Double quantity;
    private Double perItemPrice;
}
