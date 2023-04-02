package classes;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/*
 * Final Project - Mobile Library Manager Admin App
 *
 * CMPR.X413 - Java Programming II
 * @author GaudencioGalarza
 * @03-28-2023
 *
 */
@Entity
public class Book {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int bookId;
    private String title;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    private String author;
    private String barCode;
    private int yearPublished;
    private int booksInStock;

    private int daysRentable;

    private String bookCategory;

    public int getDaysRentable() {
        return daysRentable;
    }

    public void setDaysRentable(int daysRentable) {
        this.daysRentable = daysRentable;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public int getBooksInStock() {
        return booksInStock;
    }

    public void setBooksInStock(int booksInStock) {
        this.booksInStock = booksInStock;
    }

    @Ignore
    public Book(String title, String author, String barCode, int yearPublished, int booksInStock) {
        this.title = title;
        this.author = author;
        this.barCode = barCode;
        this.yearPublished = yearPublished;
        this.booksInStock = booksInStock;
    }

    @Ignore
    public Book(String title, String author, String barCode, int yearPublished) {
        this.title = title;
        this.author = author;
        this.barCode = barCode;
        this.yearPublished = yearPublished;
        this.booksInStock = 0;
    }

    public Book(String title, String author, String barCode, int yearPublished, int booksInStock, String bookCategory, int daysRentable) {
        this.title = title;
        this.author = author;
        this.barCode = barCode;
        this.yearPublished = yearPublished;
        this.booksInStock = booksInStock;
        this.bookCategory = bookCategory;
        this.daysRentable = daysRentable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }


    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

}
