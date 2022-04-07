package com.ecommerce.ecommerce.model.Response;

import com.ecommerce.ecommerce.constants.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartCostResponse extends StatusAndMessageApiResponse {
    private Double totalCost;
    public CartCostResponse(Boolean status,String message,Double totalCost) {
        super(status,message);
        this.totalCost=totalCost;
    }
    public CartCostResponse(Boolean status,String message) {
        super(status,message);
    }
    public static CartCostResponse success(Double totalCost){
        return new CartCostResponse(true, CommonConstants.SUCCESS,totalCost);
    }
    public static CartCostResponse failed(String message){
        return new CartCostResponse(false,message);
    }
}
