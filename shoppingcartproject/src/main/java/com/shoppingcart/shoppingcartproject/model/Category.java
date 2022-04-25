//    =======================================================
//    |||> This class used for
//    |||.... Category Model
//    =======================================================

package com.shoppingcart.shoppingcartproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Category {

//    ===========================================
//    |||> Category table field section
//    ===========================================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Integer id;

    private String name;

}
