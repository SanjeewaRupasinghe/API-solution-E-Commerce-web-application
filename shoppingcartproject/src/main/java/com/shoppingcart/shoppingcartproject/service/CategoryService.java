//    =======================================================
//    |||> This class used for
//    |||.... Category Service
//    =======================================================

package com.shoppingcart.shoppingcartproject.service;

import com.shoppingcart.shoppingcartproject.model.Category;
import com.shoppingcart.shoppingcartproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CategoryService {

//    ===========================================
//    |||> Autowired section
//    ===========================================

    @Autowired
    CategoryRepository categoryRepository;

//    ===========================================
//    |||> Category service method section
//    ===========================================

    public List<Category> getAllCategories(){
        return this.categoryRepository.findAll();
    }

    public void addCategory(Category category){
        this.categoryRepository.save(category);
    }

    public void removeCatById(Integer id){
        this.categoryRepository.deleteById(id);
    }

    public Optional<Category> getCatById(Integer id){
        return this.categoryRepository.findById(id);
    }

}
