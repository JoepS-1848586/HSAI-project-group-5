package com.example.hsai_project;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "reservation_table", foreignKeys = {@ForeignKey(entity = ProductEntity.class, parentColumns = "id",childColumns = "id",onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)})
public class ReservationEntity {
    @PrimaryKey
    private int id;

    public ReservationEntity(int id){
        this.id = id;
    }


    public int getId() {
        return id;
    }
}
