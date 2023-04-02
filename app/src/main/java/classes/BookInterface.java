package classes;

import android.content.Context;
import android.media.Image;

/*
 * Final Project - Mobile Library Manager Admin App
 *
 * CMPR.X413 - Java Programming II
 * @author GaudencioGalarza
 * @03-28-2023
 *
 */
public interface BookInterface {
    // check whether there is a book in stock
    public boolean bookInStock(Book book);

    // check how many books are in stock
    public int numberOfBooksInStock(Book book);

    // check how many days this book can be rented
    public int numberOfDaysRentable(Book book);

    // change the amount of days the book may be rented
    public void updateNumberOfDaysRentable(Book book, int days);

    public void oneBookIsReturned(Book book);

    public boolean createNewBook(String title, String author, String barCode, int yearPublished, int booksInStock, String bookCategory, int daysRentable, Context context);

    public void changeBookTitleTo(Book book, String title);

    public void changeBookAuthorTo(Book book, String author);


    public void changeYearPublishedTo(Book book, int year);


}
