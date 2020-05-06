package com.example.hsai_project;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "shoppincart_table", foreignKeys = {@ForeignKey(entity = ProductEntity.class, parentColumns = "id",childColumns = "id",onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)})
public class ShoppingcartEntity {
    private int id;

    @ColumnInfo(name = "amount")
    private  int amount;
}
