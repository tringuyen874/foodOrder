package com.example.foodOrder.services;

import com.example.foodOrder.models.Food;
import com.example.foodOrder.repos.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private FoodRepo foodRepo;

    public Food findByName(String name) {
        return foodRepo.findByName(name);
    }

    public Food createFood(Food food) {
        return foodRepo.save(food);
    }
}
