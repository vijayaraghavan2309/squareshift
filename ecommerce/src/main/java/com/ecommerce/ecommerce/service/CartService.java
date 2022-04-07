package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.Entity.EComCartEntity;
import com.ecommerce.ecommerce.Entity.WeightDistanceEntity;
import com.ecommerce.ecommerce.constants.CommonConstants;
import com.ecommerce.ecommerce.model.Request.AddItemRequest;
import com.ecommerce.ecommerce.model.Response.CartCostResponse;
import com.ecommerce.ecommerce.model.Response.ItemListResponse;
import com.ecommerce.ecommerce.model.Response.ItemResponse;
import com.ecommerce.ecommerce.model.Response.StatusAndMessageApiResponse;
import com.ecommerce.ecommerce.repo.EComCartRepo;
import com.ecommerce.ecommerce.repo.ItemRepo;
import com.ecommerce.ecommerce.repo.WeightDistanceRepo;
import com.ecommerce.ecommerce.validator.ItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    EComCartRepo eComCartRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ItemValidator itemValidator;

    @Autowired
    WeightDistanceRepo WeightDistanceRepo;

    public StatusAndMessageApiResponse addToCart(AddItemRequest request){
        try{
            String validateMsg= itemValidator.validateItem(request);
            if(!CommonConstants.SUCCESS.equals(validateMsg)){
                return new StatusAndMessageApiResponse(false,"Item validation failed :"+validateMsg);
            }
            eComCartRepo.save(new EComCartEntity(request));
            return new StatusAndMessageApiResponse(true,"Item added to cart");
        }catch(Exception e) {
            return new StatusAndMessageApiResponse(false,"Item addition failed :"+e.getMessage());
        }
    }

    public ItemListResponse getCartItems(Long id){
        try{
            List<ItemResponse> result= itemRepo.getItemListInCart(id);
            return ItemListResponse.success(result);
        }catch(Exception e) {
            return ItemListResponse.failed("Item retrieval failed :"+e.getMessage());
        }
    }

    public StatusAndMessageApiResponse deleteAllItemsinCart(Long id){
        try{
            eComCartRepo.deleteById(id);
            return StatusAndMessageApiResponse.success("All items deleted from cart");
        }catch(Exception e){
            return StatusAndMessageApiResponse.failed("Item deletion failed :"+e.getMessage());
        }
    }

    public Double getTotalPrice(Long id){
        return eComCartRepo.getTotalPrice(id);
    }

    public Double calculateShippmentCharges(Double weight,Double distance){
        return WeightDistanceRepo.getShippmentPrice(weight,distance);
    }

    public CartCostResponse getCartCost(Long id,Double discount,Double distance) {
        try{
            Double totalWeight=eComCartRepo.getTotalWeight(id);
            return CartCostResponse.success(getTotalPrice(id)-discount + calculateShippmentCharges(totalWeight,distance));
        }catch(Exception e){
            return CartCostResponse.failed("Cart cost calculation failed :"+e.getMessage());
        }
    }



}
