//    =======================================================
//    |||> This class used for
//    |||.... Product Model
//    =======================================================

package com.shoppingcart.shoppingcartproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Product {

//    ===========================================
//    |||> Product table field section
//    ===========================================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")

    private Category category;

    private double price;
    private double weight;
    private String description;
    private String imageName;

}
