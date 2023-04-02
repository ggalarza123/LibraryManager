package com.example.librarymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
/*
 * Final Project - Mobile Library Manager Admin App
 *
 * CMPR.X413 - Java Programming II
 * @author GaudencioGalarza
 * @03-28-2023
 *
 */

public class MainLibraryMenuActivity extends AppCompatActivity {

    Button addBookButton, manageUsers, manageBooksInventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createOnClickListeners();

    }

    private void createOnClickListeners() {
        addBookButton = findViewById(R.id.add_book);
        addBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), AddBookActivity.class);
                startActivity(intent);
            }
        });
        manageBooksInventory = findViewById(R.id.manage_books);
        manageBooksInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ViewAllBooksActivity.class);
                startActivity(intent);
            }
        });
        manageUsers = findViewById(R.id.manage_users);
        manageUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManageUsersActivity.class);
                startActivity(intent);
            }
        });
    }

}