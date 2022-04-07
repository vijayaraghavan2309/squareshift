package com.ecommerce.ecommerce.model.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemListResponse extends StatusAndMessageApiResponse {
    private List<ItemResponse> items;
    public ItemListResponse (Boolean status, String message, List<ItemResponse> items) {
        super(status, message);
        this.items= items;
    }
    public ItemListResponse(Boolean status,String message){
        super(status, message);
    }
    public static ItemListResponse success(List<ItemResponse> items){
        return new ItemListResponse(true, "Success", items);
    }
    public static ItemListResponse failed(String message){
        return new ItemListResponse(false,message);
    }
}
