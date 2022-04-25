//    =======================================================
//    |||> This class used for
//    |||.... All admin controls
//    =======================================================

package com.shoppingcart.shoppingcartproject.controller;

import com.shoppingcart.shoppingcartproject.dto.ProductDTO;
import com.shoppingcart.shoppingcartproject.model.Category;
import com.shoppingcart.shoppingcartproject.model.Product;
import com.shoppingcart.shoppingcartproject.service.CategoryService;
import com.shoppingcart.shoppingcartproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller

public class AdminController {

//    ===========================================
//    |||> Product image save directory
//    ===========================================

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages/";

//    ===========================================
//    |||> Autowired section
//    ===========================================

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

//    ===========================================
//    |||> Admin category manege section
//    ===========================================

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCategoryAdd(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCategoryAdd(@ModelAttribute("category") Category category) {
        this.categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable Integer id) {
        this.categoryService.removeCatById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable Integer id, Model model) {
        Optional<Category> catergory = this.categoryService.getCatById(id);
        if (catergory.isPresent()) {
            model.addAttribute("category", catergory.get());
            return "categoriesAdd";
        } else
            return "404";
    }

//    ===========================================
//    |||> Admin product manege section
//    ===========================================

    @GetMapping("/admin/products")
    public String getProducts(Model model) {
        model.addAttribute("products", this.productService.getAllProducts());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String productsAdd(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories", this.categoryService.getAllCategories());
        return "productsAdd";
    }

    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDTO") ProductDTO productDTO,
                                 @RequestParam("productImage") MultipartFile file,
                                 @RequestParam("imgName") String imgName) throws IOException {

        Product product = new Product();

        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(this.categoryService.getCatById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setDescription(productDTO.getDescription());

        String imageUUID;

        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(this.uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else
            imageUUID = imgName;

        product.setImageName(imageUUID);
        this.productService.addProduct(product);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProducts(@PathVariable Long id){
        this.productService.deleteProduct(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProducts(@PathVariable Long id,Model model){

        Product product=this.productService.getProdutById(id).get();

        ProductDTO productDTO=new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setWeight(product.getWeight());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageName(product.getImageName());

        model.addAttribute("categories",this.categoryService.getAllCategories());
        model.addAttribute("productDTO", productDTO);

        return "productsAdd";
    }

}