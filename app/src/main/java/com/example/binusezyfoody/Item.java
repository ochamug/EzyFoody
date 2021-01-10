package com.example.binusezyfoody;

public class Item {
    int id;
    String name;
    int price;
    int thumbnail;
    int quantity;

    public Item(int id, String name, int price, int thumbnail, int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.quantity = quantity;
    }
}
