package com.example.librarymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import classes.BookManager;

/*
 * Final Project - Mobile Library Manager Admin App
 *
 * CMPR.X413 - Java Programming II
 * @author GaudencioGalarza
 * @03-28-2023
 *
 */
public class AddBookActivity extends AppCompatActivity {


    EditText bookTitle, authorName, daysRentable, barcode, booksInStock, yearPublished, category;
    Button saveBookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_book);
        createListenerToAddBook(this);

    }

    private void createListenerToAddBook(Context context) {
        bookTitle = findViewById(R.id.editTextBookTitle);
        authorName = findViewById(R.id.editAuthorText);
        daysRentable = findViewById(R.id.editTextDaysCanRent);
        barcode = findViewById(R.id.editBarcodeText);
        booksInStock = findViewById(R.id.editBooksInStockText);
        yearPublished = findViewById(R.id.editTextYearPublished);
        category = findViewById(R.id.editTextBookCategory);

        saveBookButton = findViewById(R.id.saveButton);
        saveBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookManager bookManager = new BookManager();
                if (String.valueOf(bookTitle.getText()).isEmpty() || String.valueOf(authorName.getText()).isEmpty()
                        || String.valueOf(barcode.getText()).isEmpty() || String.valueOf(yearPublished.getText()).isEmpty() ||
                        String.valueOf(booksInStock.getText()).isEmpty() || String.valueOf(category.getText()).isEmpty() || String.valueOf(daysRentable.getText()).isEmpty()
                ) {
                    Toast.makeText(getApplicationContext(), "All fields must be filled in.", Toast.LENGTH_SHORT).show();
                } else {
                    bookManager.createNewBook(String.valueOf(bookTitle.getText()), String.valueOf(authorName.getText()), String.valueOf(barcode.getText()),
                            Integer.parseInt(String.valueOf(yearPublished.getText())), Integer.parseInt(String.valueOf(booksInStock.getText())),
                            String.valueOf(category.getText()), Integer.parseInt(String.valueOf(daysRentable.getText())), context);
                    Toast.makeText(getApplicationContext(), "Book has been saved.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}