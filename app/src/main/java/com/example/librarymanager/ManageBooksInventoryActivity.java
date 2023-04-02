package com.example.librarymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import classes.Book;
import classes.BookManager;
import database.AppDatabase;

/*
 * Final Project - Mobile Library Manager Admin App
 *
 * CMPR.X413 - Java Programming II
 * @author GaudencioGalarza
 * @03-28-2023
 *
 */
public class ManageBooksInventoryActivity extends AppCompatActivity {


    EditText bookTitle, authorName, daysRentable, barcode, booksInStock, yearPublished, category;
    Button deleteButton, saveButton, yesButton, noButton;
    BookManager bookManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_manage_books_inventory);
        retrieveBookData();
        createClickListeners();
    }

    private void createClickListeners() {
        deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDeleteDialog();
            }
        });
        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // implement save here
                editExistingBook();
            }
        });
    }

    private void editExistingBook() {
        int position = getIntent().getIntExtra("book position in list reversed", -1);
        bookManager = new BookManager();
        System.out.println("checkpoint one");
        Book book = bookManager.getBookFromReverseList(position, getApplicationContext());
        if (String.valueOf(bookTitle.getText()).isEmpty() || String.valueOf(authorName.getText()).isEmpty()
                || String.valueOf(barcode.getText()).isEmpty() || String.valueOf(yearPublished.getText()).isEmpty() ||
                String.valueOf(booksInStock.getText()).isEmpty() || String.valueOf(category.getText()).isEmpty() || String.valueOf(daysRentable.getText()).isEmpty()
        ) {
            Toast.makeText(getApplicationContext(), "All fields must be filled in.", Toast.LENGTH_SHORT).show();
        } else {
            bookManager.changeBookAuthorTo(book, String.valueOf(authorName.getText()));
            bookManager.changeBookTitleTo(book, String.valueOf(bookTitle.getText()));
            bookManager.changeYearPublishedTo(book, Integer.parseInt(String.valueOf(yearPublished.getText())));
            bookManager.updateNumberOfDaysRentable(book, Integer.parseInt(String.valueOf(daysRentable.getText())));
            bookManager.changeNumberOfBooksInStockTo(book, Integer.parseInt(String.valueOf(booksInStock.getText())));
            bookManager.changeBarcode(book, String.valueOf(barcode.getText()));
            bookManager.setCategory(book, String.valueOf(category.getText()));

            AppDatabase.getDatabase(this).getBookDao().updateBook(book);
            Toast.makeText(getApplicationContext(), "Book updated.", Toast.LENGTH_SHORT).show();
        }
    }

    private void showDeleteDialog() {
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dialog_delete_book);
        yesButton = dialog.findViewById(R.id.button_yes);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getIntent().getIntExtra("book position in list reversed", -1);
                bookManager = new BookManager();
                Book book = bookManager.getBookFromReverseList(position, getApplicationContext());
                if (bookManager.deleteBook(book, getApplicationContext()) == true) {
                    Toast.makeText(getApplicationContext(), "Book Deleted", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    finish();
                } else
                    Toast.makeText(getApplicationContext(), "Unable to delete book", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();

        noButton = dialog.findViewById(R.id.button_no);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void retrieveBookData() {
        int position = getIntent().getIntExtra("book position in list reversed", -1);
        bookTitle = findViewById(R.id.editTextBookTitle);
        authorName = findViewById(R.id.editAuthorText);
        daysRentable = findViewById(R.id.editTextDaysCanRent);
        barcode = findViewById(R.id.editBarcodeText);
        booksInStock = findViewById(R.id.editBooksInStockText);
        yearPublished = findViewById(R.id.editTextYearPublished);
        category = findViewById(R.id.editTextBookCategory);

        bookManager = new BookManager();
        Book book = bookManager.getBookFromReverseList(position, getApplicationContext());
        bookTitle.setText(bookManager.getBookTitle(book));
        authorName.setText(bookManager.getBookAuthor(book));
        barcode.setText(bookManager.getBarcode(book));
        booksInStock.setText(String.valueOf(bookManager.getBooksInStock(book)));
        yearPublished.setText(String.valueOf(bookManager.getBookYear(book)));
        category.setText(String.valueOf(bookManager.getBookCategory(book)));
        daysRentable.setText(String.valueOf(bookManager.getDaysRentable(book)));
    }


}