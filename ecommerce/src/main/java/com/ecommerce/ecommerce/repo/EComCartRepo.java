package com.ecommerce.ecommerce.repo;

import com.ecommerce.ecommerce.Entity.EComCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EComCartRepo extends JpaRepository<EComCartEntity,Long> {
    @Query(value="select sum(total_item_price) total_price from ecom_cart where id=?",nativeQuery = true)
    Double getTotalPrice(Long id);
    @Query(value="select sum(quantity*weight) total_weight from ecom_cart cart inner join items on items.id=cart.item_id where id=?",nativeQuery = true)
    Double getTotalWeight(Long id);
}
