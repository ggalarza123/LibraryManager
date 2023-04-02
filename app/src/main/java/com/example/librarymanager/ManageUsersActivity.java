package com.example.librarymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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
public class ManageUsersActivity extends AppCompatActivity {

    EditText userFirstName, userLastName, userSSN;
    Button deleteButton, addButton, yesButton, noButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_manage_users);

        createOnClickListeners();

    }

    public void createOnClickListeners() {
        userFirstName = findViewById(R.id.editTextUserFirstName);
        userLastName = findViewById(R.id.editTextUserLastName);
        userSSN = findViewById(R.id.editTextUserSSN);
        deleteButton = findViewById(R.id.delete_button);
        addButton = findViewById(R.id.add_button);


        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = userFirstName.getText().toString();
                String lastName = userLastName.getText().toString();

                if (userSSN.getText().toString().isEmpty() || firstName.isEmpty() || lastName.isEmpty() || userSSN.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please complete all fields.", Toast.LENGTH_SHORT).show();
                } else {
                    displayDeleteDialog();
                }


            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userFirstName.getText().toString().isEmpty() || userLastName.getText().toString().isEmpty() || userSSN.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please complete all fields.", Toast.LENGTH_SHORT).show();
                } else {
                    User newUser = new User(userFirstName.getText().toString(), userLastName.getText().toString(),
                            Integer.parseInt(userSSN.getText().toString()));
                    AppDatabase.getDatabase(getApplicationContext()).getUserDao().insertUser(newUser);
                    Toast.makeText(getApplicationContext(), "New user has been added!", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });


    }

    public void displayDeleteDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_delete_user);
        yesButton = dialog.findViewById(R.id.button_yes);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> listOfUsers = AppDatabase.getDatabase(getApplicationContext()).getUserDao().getAllUsers();
                String firstName = userFirstName.getText().toString();
                String lastName = userLastName.getText().toString();
                int currLength = listOfUsers.size();
                for (int i = 0; i < listOfUsers.size(); i++) {
                    if (listOfUsers.get(i).getFirstName().equals(firstName) && listOfUsers.get(i).getLastName().equals(lastName) &&
                            listOfUsers.get(i).getLastFourSSN() == Integer.parseInt(userSSN.getText().toString())) {
                        AppDatabase.getDatabase(getApplicationContext()).getUserDao().deleteUser(listOfUsers.get(i));
                        Toast.makeText(getApplicationContext(), "User deleted.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        finish();
                    }
                }
                listOfUsers = AppDatabase.getDatabase(getApplicationContext()).getUserDao().getAllUsers();
                if (currLength == listOfUsers.size()) {
                    Toast.makeText(getApplicationContext(), "No such user found.", Toast.LENGTH_SHORT).show();
                }

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


}