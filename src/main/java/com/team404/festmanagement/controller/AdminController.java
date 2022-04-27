package com.team404.festmanagement.controller;

import com.team404.festmanagement.dto.FoodDTO;
import com.team404.festmanagement.dto.MerchDTO;
import com.team404.festmanagement.model.Category;
import com.team404.festmanagement.model.Food;
import com.team404.festmanagement.model.Merch;
import com.team404.festmanagement.service.CategoryService;
import com.team404.festmanagement.service.FoodService;
import com.team404.festmanagement.service.MerchService;
import com.team404.festmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {


    @Autowired
    CategoryService categoryService;

    @Autowired
    MerchService merchService;

    @Autowired
    FoodService foodService;

    @Autowired
    UserService userService;

    public AdminController() throws IOException {

    }

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCategoriesAdd(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCategoriesAdd(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String getCategoriesDelete(@PathVariable int id)
    {
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCategories(@PathVariable int id, Model model){
        Optional<Category>  category = categoryService.getCategoryByID(id);
    if(category.isPresent()) {
        model.addAttribute("category", category.get());
            return "categoriesAdd";
    }else
        return "404"; //Item not found
    }

    //Merch section

    @GetMapping("/admin/merch")
    public String getMerch(Model model)
    {
        model.addAttribute("merch", merchService.getAllMerch());
        return "merch";
    }

    @GetMapping("/admin/merch/add")
    public String getMerchAdd(Model model){
        model.addAttribute("merchDTO", new MerchDTO());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "merchAdd";
    }

    @PostMapping("/admin/merch/add")
    public String merchAddPost(@ModelAttribute("merchDTO")MerchDTO merchDTO) throws IOException {

        //Converting DTO back into Object
        Merch merch = new Merch();
        merch.setId(merchDTO.getId());
        merch.setDescription(merchDTO.getDescription());
        merch.setPrice(merchDTO.getPrice());
        merch.setSize(merchDTO.getSize());
        merch.setCategory(categoryService.getCategoryByID(merchDTO.getCategoryID()).get());
        merch.setName(merchDTO.getName());
            merchService.addMerch(merch);
            return "redirect:/admin/merch";

        }


        @GetMapping("/admin/merch/delete/{id}")
        public String deleteMerch ( @PathVariable long id){
            merchService.removeMerchByID(id);
            return "redirect:/admin/merch";
        }

        @GetMapping("/admin/merch/update/{id}")
        public String updateMerch ( @PathVariable long id, Model model){
            Merch merch = merchService.getMerchByID(id).get();

            //Making product DTO object
            MerchDTO merchDTO = new MerchDTO();
            merchDTO.setId(merch.getId());
            merchDTO.setPrice(merch.getPrice());
            merchDTO.setName(merch.getName());
            merchDTO.setCategoryID(merch.getCategory().getId());
            merchDTO.setDescription(merch.getDescription());
            merchDTO.setSize(merch.getSize());

            model.addAttribute("categories", categoryService.getAllCategory());
            model.addAttribute("merchDTO", merchDTO);


            return "merchAdd";
        }


        //Food section

    @GetMapping("/admin/food")
    public String getFood(Model model)
    {
        model.addAttribute("food", foodService.getAllFood());
        return "food";
    }

    @GetMapping("/admin/food/add")
    public String getFoodAdd(Model model){
        model.addAttribute("foodDTO", new FoodDTO());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "foodAdd";
    }

    @PostMapping("/admin/food/add")
    public String foodAddPost(@ModelAttribute("foodDTO") FoodDTO foodDTO) throws IOException {

        //Converting DTO back into Object
        Food food = new Food();
        food.setId(foodDTO.getId());
        food.setStallLocation(foodDTO.getStallLocation());
        food.setName(foodDTO.getName());
        food.setStallName(foodDTO.getStallName());
        food.setUser(userService.getUserByID(foodDTO.getUserID()).get());
        foodService.addFood(food);
        return "redirect:/admin/food";

    }


    @GetMapping("/admin/food/delete/{id}")
    public String deleteFood ( @PathVariable long id){
        foodService.removeFoodByID(id);
        return "redirect:/admin/food";
    }

    @GetMapping("/admin/food/update/{id}")
    public String updateFood ( @PathVariable long id, Model model){
        Food food = foodService.getFoodByID(id).get();

        //Making product DTO object
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setId(food.getId());
        foodDTO.setStallLocation(food.getStallLocation());
        foodDTO.setName(food.getName());
        foodDTO.setUserID(Math.toIntExact(food.getUser().getId()));
        foodDTO.setStallName(food.getStallName());

        model.addAttribute("user", userService.getAllUser());
        model.addAttribute("foodDTO", foodDTO);


        return "foodAdd";
    }




}
