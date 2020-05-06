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

    @Query("SELECT * FROM product_table ORDER BY Price DESC")
    LiveData<List<ProductEntity>>getAllProducts();

    @Query("SELECT x.productName,x.Price,x.Store,y.amount FROM product_table as x,shoppincart_table as y WHERE x.id = y.id")
    LiveData<List<ShoppincartData>> getAllShoppingcartProducts();
}
