package org.example.models;

import org.example.enums.ItemType;

public class Item {
    public int code;
    public ItemType type;
    public int maxQuantity = 10;
    public int quantity;
    public double price;

    public Item(int code, ItemType type, int maxQuantity, int quantity, double price) {
        this.code = code;
        this.type = type;
        this.maxQuantity = maxQuantity;
        this.quantity = quantity;
        this.price = price;
    }
}
