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
    private String categorie;

    // explore data
    private int timesviewed = 0;
    private int timesbought = 0;

    public ProductEntity(String productName, int Price, String Store, String categorie) {
        this.productName = productName;
        this.Price = Price;
        this.Store = Store;
        this.categorie = categorie;
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

    public String getCategorie() { return this.categorie;}

    public int getTimesbought() {
        return timesbought;
    }

    public int getTimesviewed() {
        return timesviewed;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setTimesbought(int timesbought) {
        this.timesbought = timesbought;
    }

    public void setTimesviewed(int timesviewed) {
        this.timesviewed = timesviewed;
    }

    public void addView() { timesviewed+=1;}
    public void addBuy() { timesbought += 1;}

}
