package classes;

import android.content.Context;

import java.util.Collections;
import java.util.List;

import database.AppDatabase;

/*
 * Final Project - Mobile Library Manager Admin App
 *
 * CMPR.X413 - Java Programming II
 * @author GaudencioGalarza
 * @03-28-2023
 *
 */
public class BookManager implements BookInterface {

    List<Book> listOfBooks;

    public boolean bookInStock(Book book) {
        if (!(book.getBooksInStock() >= 1)) {
            return false;
        }
        return true;
    }

    public Book getBookFromReverseList(int position, Context context) {
        listOfBooks = AppDatabase.getDatabase(context).getBookDao().getAllBooks();
        Collections.reverse(listOfBooks);
        Book book = listOfBooks.get(position);
        return book;
    }

    public boolean deleteBook(Book book, Context context) {
        AppDatabase.getDatabase(context).getBookDao().deleteBook(book);
        return true;
    }

    public void changeBarcode(Book book, String barcode) {
        book.setBarCode(barcode);
    }

    public void changeNumberOfBooksInStockTo(Book book, int stock) {
        book.setBooksInStock(stock);
    }

    public void setCategory(Book book, String category) {
        book.setBookCategory(category);
    }

    public int getDaysRentable(Book book) {
        return book.getDaysRentable();
    }

    public String getBookCategory(Book book) {
        return book.getBookCategory();
    }

    @Override
    public int numberOfBooksInStock(Book book) {
        return book.getBooksInStock();
    }

    @Override
    public int numberOfDaysRentable(Book book) {
        return book.getDaysRentable();
    }

    @Override
    public void updateNumberOfDaysRentable(Book book, int days) {
        book.setDaysRentable(days);
    }

    @Override
    public void oneBookIsReturned(Book book) {
        book.setBooksInStock(book.getBooksInStock() + 1);
    }

    @Override
    public boolean createNewBook(String title, String author, String barCode, int yearPublished, int booksInStock, String bookCategory, int daysRentable, Context context) {
        Book book = new Book(title, author, barCode, yearPublished, booksInStock, bookCategory, daysRentable);
        AppDatabase.getDatabase(context).getBookDao().insertBook(book);
        return true;
    }

    @Override
    public void changeBookTitleTo(Book book, String title) {
        book.setTitle(title);
    }

    @Override
    public void changeBookAuthorTo(Book book, String author) {
        book.setAuthor(author);
    }


    @Override
    public void changeYearPublishedTo(Book book, int year) {
        book.setYearPublished(year);
    }

    public String getBookTitle(Book book) {
        return book.getTitle();
    }

    public String getBookAuthor(Book book) {
        return book.getAuthor();
    }

    public String getBarcode(Book book) {
        return book.getBarCode();
    }

    public int getBookYear(Book book) {
        return book.getYearPublished();
    }

    public int getBooksInStock(Book book) {
        return book.getBooksInStock();
    }

}
