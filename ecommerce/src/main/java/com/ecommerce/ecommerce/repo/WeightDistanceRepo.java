package com.ecommerce.ecommerce.repo;

import com.ecommerce.ecommerce.Entity.WeightDistanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightDistanceRepo extends JpaRepository<WeightDistanceEntity, Long>  {
    @Query(value="select price from weight_distance where ? between min_weight and max_weight and ? between min_distane and max_distance", nativeQuery = true)
    Double getShippmentPrice(Double weight, Double distance);
}
