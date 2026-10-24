package com.nutrilens.api.repository;

import com.nutrilens.api.entity.NutritionTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NutritionTipRepository extends JpaRepository<NutritionTip, Long> {

    List<NutritionTip> findByIsActiveTrueOrderByIdAsc();

    List<NutritionTip> findByIsActiveTrueAndTargetGoalInOrderByIdAsc(List<String> targetGoals);

    @Query(value = "SELECT * FROM nutrition_tips WHERE is_active = true ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<NutritionTip> findRandomActiveTip();
}
