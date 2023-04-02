package com.example.librarymanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import classes.BookAdapter;
import database.AppDatabase;

/*
 * Final Project - Mobile Library Manager Admin App
 *
 * CMPR.X413 - Java Programming II
 * @author GaudencioGalarza
 * @03-28-2023
 *
 */
public class ViewAllBooksActivity extends AppCompatActivity {

    RecyclerView booksListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycler_view_all_books);
        booksListView = findViewById(R.id.recycler_view_all_books);
        BookAdapter bookAdapter = new BookAdapter(this, AppDatabase.getDatabase(getApplicationContext()).getBookDao().getAllBooks());
        booksListView.setAdapter(bookAdapter);
        booksListView.setLayoutManager(new LinearLayoutManager(this));

    }

}