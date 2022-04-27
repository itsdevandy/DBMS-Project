package com.team404.festmanagement.global;


import com.team404.festmanagement.model.Merch;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Merch> cart;
    static{
        cart = new ArrayList<Merch>();
    }
}
