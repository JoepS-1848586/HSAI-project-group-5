package com.example.hsai_project;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "wishlist_table", foreignKeys = {@ForeignKey(entity = ProductEntity.class, parentColumns = "id",childColumns = "id",onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)})
public class WishlistEntity {
    @PrimaryKey
    private int id;

    public WishlistEntity(int id){
        this.id = id;
    }


    public int getId() {
        return id;
    }
}
