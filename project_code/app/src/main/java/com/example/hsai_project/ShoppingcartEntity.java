package com.example.hsai_project;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "shoppincart_table", foreignKeys = {@ForeignKey(entity = ProductEntity.class, parentColumns = "id",childColumns = "id",onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)})
public class ShoppingcartEntity {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "amount")
    private  int amount;

    public ShoppingcartEntity(int id, int amount){
        this.id = id;
        this.amount = amount;
    }


    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }
}
