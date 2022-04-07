package com.ecommerce.ecommerce.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="weight_distance")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeightDistanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="min_weight")
    private Double minWeight;

    @Column(name="max_weight")
    private Double maxWeight;

    @Column(name="min_distance")
    private Double minDistance;

    @Column(name="max_distance")
    private Double maxDistance;

    @Column(name="price")
    private Double price;
}
