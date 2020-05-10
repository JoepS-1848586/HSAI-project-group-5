package com.example.hsai_project;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hsai_project.fragments.reservations.ReservationItem;
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

    @Query("SELECT * FROM product_table ORDER BY Price ASC")
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

    @Query("DELETE FROM shoppincart_table WHERE id = :id")
    void deleteFromShoppingCart(int id);

    // reservations table
    @Insert
    void insertReservation(ReservationEntity product);
    @Update
    void updateReservation(ReservationEntity product);
    @Delete
    void deleteReservation(ReservationEntity product);

    @Query("SELECT x.id,x.productName,x.Price,x.Store,y.amount FROM product_table as x,reservation_table as y WHERE x.id = y.id")
    LiveData<List<ReservationItem>> getAllReservations();

    @Query("DELETE FROM reservation_table WHERE id = :id")
    void deleteFromReservations(int id);

    // wishlist table
    @Insert
    void insertWishlist(WishlistEntity product);
    @Update
    void updateWishlist(WishlistEntity product);
    @Query("DELETE FROM wishlist_table WHERE wishlist_table.id = :id")
    void deleteWishlist(int id);

    // explore
    @Query("SELECT * FROM product_table ORDER BY timesviewed LIMIT 10")
    LiveData<List<ProductEntity>> getTopViewed();

    @Query("SELECT * FROM product_table ORDER BY timesbought LIMIT 10")
    LiveData<List<ProductEntity>> getTopBought();

    @Query("SELECT * FROM product_table WHERE categorie = :cat ORDER BY timesviewed LIMIT 10")
    LiveData<List<ProductEntity>> get10Cat(String cat);

    // wishlist
    @Query("SELECT * FROM product_table WHERE isWishlist == 1 ORDER BY Price DESC")
    LiveData<List<ProductEntity>>getAllWishlistProducts();


}
