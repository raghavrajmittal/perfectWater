package model;

import java.io.Serializable;

/**
 * An Enum class that contains all the possible User Types of a regsitered user in the app
 */
public enum UserType implements Serializable{
    USER("User"),
    MANAGER("Manager"),
    WORKER("Worker"),
    ADMIN("Admin");

    private String userType;

    UserType(String ut){
        userType = ut;
    }

    //toString Method for UserType Enum
    public String toString(){
        return userType;
    }
}
