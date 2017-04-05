package model;

/**
 * A user object that contains all necessary information about the user
 */

public class User {

    private String Name;
    private String username;
    private String password;
    private UserType usertype;

    private String homeAddress;
    private String emailAddress;


    public User(String name, String username, String password, String homeAddress, String emailAddress) {
        this.name = name;
        this.username = username;
        this.emailAddress = emailAddress;
        this.homeAddress = homeAddress;
        this.emailAddress = emailAddress;

    }
    //make getters and setters for each, if somehow firebase doesn't work?
}
