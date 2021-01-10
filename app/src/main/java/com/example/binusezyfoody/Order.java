package com.example.binusezyfoody;

import android.os.Build;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    int totalPrice;
    String orderTime;
    ArrayList<Item> orders;

    public Order(int totalPrice, ArrayList<Item> orders){
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        this.orders = orders;
        this.totalPrice = totalPrice;
        orderTime = dtf.format(System.currentTimeMillis());
    }
}
