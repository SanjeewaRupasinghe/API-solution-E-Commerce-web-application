//    =======================================================
//    |||> This class used for
//    |||.... Product Service
//    =======================================================

package com.shoppingcart.shoppingcartproject.service;

import com.shoppingcart.shoppingcartproject.model.Product;
import com.shoppingcart.shoppingcartproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductService {

//    ===========================================
//    |||> Autowired section
//    ===========================================

    @Autowired
    ProductRepository productRepository;

//    ===========================================
//    |||> Category service method section
//    ==========================================

    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public void addProduct(Product product){
        this.productRepository.save(product);
    }

    public void deleteProduct(Long id){
        this.productRepository.deleteById(id);
    }

    public Optional<Product> getProdutById(Long id){
        return this.productRepository.findById(id);
    }

    public List<Product> findAllByCategoryId(Integer id){
        return this.productRepository.findAllByCategoryId(id);
    }

}