package com.ecommerce.ecommerce.validator;

import com.ecommerce.ecommerce.constants.CommonConstants;
import com.ecommerce.ecommerce.constants.ItemConstants;
import com.ecommerce.ecommerce.model.Request.AddItemRequest;
import org.springframework.stereotype.Component;

@Component
public class ItemValidator {
    public String validateItem(AddItemRequest request){
        if(request.getQuantity()<=0)
            return ItemConstants.INVALID_QUANTITY;
        else if (request.getPerItemPrice()<=0)
            return ItemConstants.INVALID_PER_ITEM_PRICE;
        return CommonConstants.SUCCESS;
    }
}
