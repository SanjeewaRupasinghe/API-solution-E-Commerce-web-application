//    =======================================================
//    |||> This interface used for
//    |||.... Category connection create with database
//    =======================================================

package com.shoppingcart.shoppingcartproject.repository;

import com.shoppingcart.shoppingcartproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
