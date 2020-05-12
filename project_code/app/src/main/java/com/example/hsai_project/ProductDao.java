package com.example.hsai_project;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insert(ProductEntity product);
    @Update
    void update(ProductEntity product);
    @Delete
    void delete(ProductEntity product);

    @Query("SELECT * FROM product_table ORDER BY Price ASC")
    LiveData<List<ProductEntity>>getAllProducts();

    @Query("SELECT * FROM product_table WHERE isWishlist == 1 ORDER BY Price ASC")
    LiveData<List<ProductEntity>>getAllWishlistProducts();

    @Query("SELECT * FROM product_table WHERE inCompare = 1")
    LiveData<List<ProductEntity>>getAllCompareProducts();

    @Query("SELECT * FROM product_table WHERE id = :id")
    LiveData<List<ProductEntity>>getFullProduct(int id);


}
