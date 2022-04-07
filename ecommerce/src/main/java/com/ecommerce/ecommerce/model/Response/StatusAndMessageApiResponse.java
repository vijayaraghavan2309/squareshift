package com.ecommerce.ecommerce.model.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusAndMessageApiResponse {
    private Boolean status;
    private String message;
    public static StatusAndMessageApiResponse success(String message){
        return new StatusAndMessageApiResponse(true,message);
    }
    public static StatusAndMessageApiResponse failed(String message){
        return new StatusAndMessageApiResponse(false,message);
    }
}
