package com.team404.festmanagement.controller;


import com.team404.festmanagement.global.GlobalData;
import com.team404.festmanagement.model.Merch;
import com.team404.festmanagement.service.MerchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {
    @Autowired
    MerchService merchService;
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id) {
        GlobalData.cart.add(merchService.getMerchByID(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String cartGet(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Merch::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }


    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index) {
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Merch::getPrice).sum());
                return "checkout";

    }
}
