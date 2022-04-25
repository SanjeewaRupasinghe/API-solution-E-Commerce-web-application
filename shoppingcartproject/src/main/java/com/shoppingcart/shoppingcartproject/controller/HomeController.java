//    =======================================================
//    |||> This class used for
//    |||.... All home controls
//    =======================================================

package com.shoppingcart.shoppingcartproject.controller;

import com.shoppingcart.shoppingcartproject.global.GlobalData;
import com.shoppingcart.shoppingcartproject.service.CategoryService;
import com.shoppingcart.shoppingcartproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class HomeController {

//    ===========================================
//    |||> Autowired section
//    ===========================================

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

//    ===========================================
//    |||> Mapping section
//    ===========================================

    @GetMapping({"/","/home"})
    public String home(){
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories",this.categoryService.getAllCategories());
        model.addAttribute("products",this.productService.getAllProducts());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable Integer id){
        model.addAttribute("categories",this.categoryService.getAllCategories());
        model.addAttribute("products",this.productService.findAllByCategoryId(id));
        model.addAttribute("cartCount",GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model,@PathVariable Long id){
        model.addAttribute("product" ,this.productService.getProdutById(id).get());
        model.addAttribute("cartCount",GlobalData.cart.size());
        return "viewProduct";
    }

}