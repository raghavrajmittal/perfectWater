package model;

import com.example.thushara.perfectwater.Controller.HomeScreen;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

/**
 * A user object that contains all necessary information about the user
 */

public class User {

    private String name;
//    private String password;
    private String usertype;

    private String zipcode;
    private String emailAddress;


    public User(String name, String zipcode, String userType) {
        this.name = name;
        //this.emailAddress = emailAddress;
        this.zipcode = zipcode;
        this.usertype = userType;

    }
    //make getters and setters for each, if somehow firebase doesn't work?

    /*
    writes a user to database
     */

    public void writeToDatabase(String userid) {
        FirebaseAuth auth = HomeScreen.getAuth();
        DatabaseReference userDatabase = HomeScreen.getUserDatabase();
        userDatabase.child(userid).child("Name").setValue(name);
        userDatabase.child(userid).child("Email").setValue(auth.getCurrentUser().getEmail());
        userDatabase.child(userid).child("Zipcode").setValue(zipcode);
        userDatabase.child(userid).child("User Type").setValue(usertype);
    }

    public void deleteUser(String userid) {
        DatabaseReference userDatabase = HomeScreen.getUserDatabase();
        userDatabase.child(userid).removeValue();
    }
}
