package com.ecommerce.ecommerce.Entity;

import com.ecommerce.ecommerce.model.Request.AddItemRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ecom_cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EComCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="item_id")
    private Long itemId;

    @Column(name="quantity")
    private Double quantity;

    @Column(name="per_item_price")
    private Double perItemPrice;

    @Column(name="total_item_price")
    private Double totalItemPrice;

    public EComCartEntity (AddItemRequest addItemRequest){
        this.itemId= addItemRequest.getId();
        this.quantity= addItemRequest.getQuantity();
        this.perItemPrice= addItemRequest.getPerItemPrice();
        this.totalItemPrice= addItemRequest.getPerItemPrice()* addItemRequest.getQuantity();
    }
}
