package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Request.AddItemRequest;
import com.ecommerce.ecommerce.model.Response.CartCostResponse;
import com.ecommerce.ecommerce.model.Response.ItemListResponse;
import com.ecommerce.ecommerce.model.Response.StatusAndMessageApiResponse;
import com.ecommerce.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class EComController {
    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<StatusAndMessageApiResponse> addItemtoCart(@RequestBody AddItemRequest request){
        StatusAndMessageApiResponse response= cartService.addToCart(request);
        return response.getStatus()?ResponseEntity.ok(response):ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ItemListResponse> getCartItems(@PathVariable("id") Long id){
        ItemListResponse response= cartService.getCartItems(id);
        return response.getStatus()?ResponseEntity.ok(response):ResponseEntity.badRequest().body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StatusAndMessageApiResponse> deleteCart(@PathVariable("id") Long id){
        StatusAndMessageApiResponse response= cartService.deleteAllItemsinCart(id);
        return response.getStatus()?ResponseEntity.ok(response):ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/calculate_cost/{id}")
    public ResponseEntity<CartCostResponse> calculateCartCost(@PathVariable("id") Long id,@RequestParam("discount") Double discount,@RequestParam("distance") Double distance){
        CartCostResponse response= cartService.getCartCost(id,discount,distance);
        return response.getStatus()?ResponseEntity.ok(response):ResponseEntity.badRequest().body(response);
    }
}
