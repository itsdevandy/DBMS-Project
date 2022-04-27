package com.team404.festmanagement.service;

import com.team404.festmanagement.model.Food;
import com.team404.festmanagement.model.User;
import com.team404.festmanagement.repository.FoodRepository;
import com.team404.festmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository  userRepository;

    public List<User> getAllUser(){ return userRepository.findAll();}
    public void addUser(User user){
        userRepository.save(user);
    }

    public void removeUserByID(long id){
        userRepository.deleteById((int) id);
    }

    public Optional<User> getUserByID(long id){
        return userRepository.findById((int) id);
    }
}
