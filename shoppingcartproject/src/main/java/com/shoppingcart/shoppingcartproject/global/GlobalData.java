//    =======================================================
//    |||> This class used for
//    |||.... Global
//    =======================================================

package com.shoppingcart.shoppingcartproject.global;

import com.shoppingcart.shoppingcartproject.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

//    ===========================================
//    |||> Create CART as static for global use
//    ===========================================

    public static List<Product> cart;
    static {
        cart =new ArrayList<Product>();

    }

}
