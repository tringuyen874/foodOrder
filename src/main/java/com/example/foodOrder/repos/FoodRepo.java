package com.example.foodOrder.repos;

import com.example.foodOrder.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Long> {

    Food findByName(String name);
}
