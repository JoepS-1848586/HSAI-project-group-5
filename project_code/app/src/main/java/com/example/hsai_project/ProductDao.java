package com.example.hsai_project;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hsai_project.fragments.shoppingcart.ShoppingcartItem;

import java.util.List;

@Dao
public interface ProductDao {

    // product table
    @Insert
    void insert(ProductEntity product);
    @Update
    void update(ProductEntity product);
    @Delete
    void delete(ProductEntity product);

    @Query("SELECT * FROM product_table ORDER BY Price DESC")
    LiveData<List<ProductEntity>>getAllProducts();

    // shoppingcart table
    @Insert
    void insertShoppingcart(ShoppingcartEntity product);
    @Update
    void updateShoppingcart(ShoppingcartEntity product);
    @Delete
    void deleteShoppingcart(ShoppingcartEntity product);

    @Query("SELECT x.id,x.productName,x.Price,x.Store,y.amount FROM product_table as x,shoppincart_table as y WHERE x.id = y.id")
    LiveData<List<ShoppingcartItem>> getAllShoppingcartProducts();

    // wishlist table
    @Insert
    void insertWishlist(WishlistEntity product);
    @Update
    void updateWishlist(WishlistEntity product);
    @Query("DELETE FROM wishlist_table WHERE wishlist_table.id = :id")
    void deleteWishlist(int id);
}
