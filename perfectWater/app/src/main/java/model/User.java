package model;

import com.example.thushara.perfectwater.Controller.HomeScreen;
import com.google.firebase.database.DatabaseReference;

/**
 * A user object that contains all necessary information about the user
 */

public class User {

    private String name;
    private String username;
    private String password;
    private UserType usertype;

    private String homeAddress;
    private String emailAddress;


//    public User(String name, String username, String password, String homeAddress, String emailAddress) {
//        this.name = name;
//        this.username = username;
//        this.emailAddress = emailAddress;
//        this.homeAddress = homeAddress;
//        this.emailAddress = emailAddress;
//
//    }
    //make getters and setters for each, if somehow firebase doesn't work?

    /*
    writes a user to database
     */

    public void writeToDatabase(String userid) {
        DatabaseReference userDatabase = HomeScreen.getUserDatabase();
        userDatabase.child(userid).child("Name").setValue(name);
        userDatabase.child(userid).child("Email").setValue(name);
        userDatabase.child(userid).child("Address").setValue(homeAddress);
        userDatabase.child(userid).child("Email").setValue(name);
        userDatabase.child(userid).child("User Type").setValue(usertype);
    }

    public void deleteUser(String userid) {
        DatabaseReference userDatabase = HomeScreen.getUserDatabase();
        userDatabase.child(userid).removeValue();
    }
}
