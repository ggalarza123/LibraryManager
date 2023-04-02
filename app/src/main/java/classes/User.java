package classes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
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
public class User {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int userId;
    private String firstName;
    private String lastName;

    private String userName;

    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int lastFourSSN;

    public int getLastFourSSN() {
        return lastFourSSN;
    }

    public void setLastFourSSN(int lastFourSSN) {
        this.lastFourSSN = lastFourSSN;
    }

    public User(String firstName, String lastName, int lastFourSSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastFourSSN = lastFourSSN;
        this.userName = firstName + lastName;
        this.password = lastName + lastFourSSN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
