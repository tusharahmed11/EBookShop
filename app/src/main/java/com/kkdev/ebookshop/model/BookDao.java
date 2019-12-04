package com.kkdev.ebookshop.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDao {

    @Insert
    void Insert(Book book);

    @Update
    void Update(Book book);

    @Delete
    void Delete(Book book);

    @Query("SELECT * FROM books_table")
    LiveData<List<Book>> getAllBooks();

    @Query("SELECT * FROM books_table WHERE category_id==:categoryId")
    LiveData<List<Book>> getBooks(int categoryId);

}
