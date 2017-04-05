package model;

import java.util.ArrayList;

/**
 * Manager class
 */

public class Manager {

    private static ArrayList<Manager> allManagers;
    private String name;
    private String username;
    private String password;
    private UserType usertype;

    private String homeAddress;
    private String emailAddress;


    public Manager(String name, String username, String password, String homeAddress, String emailAddress) {
        this.name = name;
        this.username = username;
        this.emailAddress = emailAddress;
        this.homeAddress = homeAddress;
        this.emailAddress = emailAddress;
    }
}


//Make setters and getters, if firebase does not work