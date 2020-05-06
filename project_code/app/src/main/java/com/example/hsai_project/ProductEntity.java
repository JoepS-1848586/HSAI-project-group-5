package com.example.hsai_project;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product_table")
public class ProductEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String productName;
    private int Price;
    private String Store;

    public ProductEntity(String productName, int Price, String Store) {
        this.productName = productName;
        this.Price = Price;
        this.Store = Store;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setStore(String store) {
        Store = store;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return Price;
    }

    public String getStore() {
        return Store;
    }
}
