package com.ecommerce.ecommerce.model.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {
    private String id;
    private String itemName;
    private String description;
    private Double perItemPrice;
    private Double quantity;
    private Double totalPrice;
}
