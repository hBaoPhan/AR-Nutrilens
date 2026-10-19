package com.nutrilens.api.repository;

import com.nutrilens.api.entity.FoodDensity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodDensityRepository extends JpaRepository<FoodDensity, Long> {
    Optional<FoodDensity> findByFoodCodeAndIsActiveTrue(String foodCode);
}
