package com.example.librarymanager;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import classes.User;
import database.AppDatabase;

/*
 * Final Project - Mobile Library Manager Admin App
 *
 * CMPR.X413 - Java Programming II
 * @author GaudencioGalarza
 * @03-28-2023
 *
 */
public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Less secure, more direct approach, but to save time doing it this way
                List<User> userList = AppDatabase.getDatabase(getApplicationContext()).getUserDao().getAllUsers();
                String inputUsername = String.valueOf(username.getText());
                String inputPassword = String.valueOf(password.getText());
                System.out.println(inputUsername);
                System.out.println(inputPassword);
                for (int i = 0; i < userList.size(); i++) {
                    // if user name matches
                    if (userList.get(i).getUserName().equals(inputUsername)) {
                        // and if password matches
                        if (userList.get(i).getPassword().equals(inputPassword)) {
                            Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainLibraryMenuActivity.class);
                            startActivity(intent);
                            break;
                        }
                    } else if (username.getText().toString().equals("Admin") && password.getText().toString().equals("1234")) {
                        Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainLibraryMenuActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();
                    }
                }
                if (userList.size() == 0) {
                    if (username.getText().toString().equals("Admin") && password.getText().toString().equals("1234")) {
                        Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainLibraryMenuActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}