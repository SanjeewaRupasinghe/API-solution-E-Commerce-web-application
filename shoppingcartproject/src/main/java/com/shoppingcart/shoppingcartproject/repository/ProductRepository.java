//    =======================================================
//    |||> This interface used for
//    |||.... Product connection create with database
//    =======================================================

package com.shoppingcart.shoppingcartproject.repository;

import com.shoppingcart.shoppingcartproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategoryId(Integer id);

}
