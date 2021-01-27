package com.example.utsarisalfauzi;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM product")
    List<Product> getAll();

    @Query("SELECT * FROM product WHERE id = :id")
    Product findById(int id);

    @Query("SELECT * FROM product WHERE nama = :nama")
    Product findByNama(String nama);

    @Insert
    void insertAll(Product... product);

    @Insert
    long insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);

    @Delete
    void delete(Product... product);
}
