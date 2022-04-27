package com.team404.festmanagement.service;

import com.team404.festmanagement.model.Food;
import com.team404.festmanagement.model.Merch;
import com.team404.festmanagement.repository.FoodRepository;
import com.team404.festmanagement.repository.MerchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;
    public List<Food> getAllFood(){ return foodRepository.findAll();}
    public void addFood(Food food){
        foodRepository.save(food);
    }

    public void removeFoodByID(long id){
        foodRepository.deleteById(id);
    }

    public Optional<Food> getFoodByID(long id){
        return foodRepository.findById(id);
    }

}
