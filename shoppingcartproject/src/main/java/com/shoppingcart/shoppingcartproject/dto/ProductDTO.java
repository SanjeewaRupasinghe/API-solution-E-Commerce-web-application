//    =======================================================
//    |||> This class used for
//    |||.... Product data transfer object
//    =======================================================

package com.shoppingcart.shoppingcartproject.dto;

import lombok.Data;

@Data

public class ProductDTO {

//    ===========================================
//    |||> Variable create section
//    ===========================================

    private Long id;
    private String name;
    private Integer categoryId;
    private double price;
    private double weight;
    private String description;
    private String imageName;

}