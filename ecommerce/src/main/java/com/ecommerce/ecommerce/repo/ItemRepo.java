package com.ecommerce.ecommerce.repo;

import com.ecommerce.ecommerce.Entity.ItemEntity;
import com.ecommerce.ecommerce.model.Response.ItemResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<ItemEntity,Long> {
    @Query(value="select cart.item_id,item.name,item.description,cart.per_item_price,cart.quantity,cart.total_item_price from ecom_cart cart inner join items item on cart.item_id=item.id where cart.id=?",nativeQuery = true)
    List<ItemResponse> getItemListInCart(Long id);
}
