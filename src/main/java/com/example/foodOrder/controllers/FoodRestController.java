package com.example.foodOrder.controllers;

import com.example.foodOrder.models.Food;
import com.example.foodOrder.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodapi")
public class FoodRestController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/food/{name}")
    public Food findByName(@PathVariable String name) {
        return foodService.findByName(name);
    }

    @PostMapping("/food")
    public Food createFood(@RequestBody Food food) {
        return foodService.createFood(food);
    }
}
