package com.team404.festmanagement.controller;

import com.team404.festmanagement.global.GlobalData;
import com.team404.festmanagement.model.Merch;
import com.team404.festmanagement.service.CategoryService;
import com.team404.festmanagement.service.MerchService;
import org.apache.tomcat.jni.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    MerchService merchService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("merch", merchService.getAllMerch());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("merch", merchService.getAllMerchByCategoryID(id)); //Sort by category
        return "shop";
    }

    @GetMapping("/shop/viewmerch/{id}")
    public String viewMerch(Model model, @PathVariable int id){
        model.addAttribute("merch", merchService.getMerchByID(id).get());
        return "viewMerch";
    }



}
