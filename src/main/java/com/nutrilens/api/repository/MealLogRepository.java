package com.nutrilens.api.repository;

import com.nutrilens.api.entity.MealLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealLogRepository extends JpaRepository<MealLog, Long> {
    List<MealLog> findAllByOrderByLoggedAtDesc();
    List<MealLog> findByUserIdOrderByLoggedAtDesc(Long userId);
    List<MealLog> findByUserUsernameOrderByLoggedAtDesc(String username);
}
