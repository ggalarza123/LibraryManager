package database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


import classes.Book;

/*
 * Final Project - Mobile Library Manager Admin App
 *
 * CMPR.X413 - Java Programming II
 * @author GaudencioGalarza
 * @03-28-2023
 *
 */
@Dao
public interface BookDao {
    @Query("Select * from Book")
    List<Book> getAllBooks();

    @Insert
    void insertBook(Book book);

    @Update
    void updateBook(Book book);

    @Delete
    void deleteBook(Book book);

}
