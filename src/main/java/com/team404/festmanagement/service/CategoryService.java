package com.team404.festmanagement.service;

import com.team404.festmanagement.model.Category;
import com.team404.festmanagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void removeCategoryById(int id) {categoryRepository.deleteById(id);}

    public Optional<Category> getCategoryByID(int id) {return categoryRepository.findById(id);
    }
}
