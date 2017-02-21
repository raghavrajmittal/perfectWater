package model;

import java.io.Serializable;

/**
 * Created by raghavrajmittal on 21/02/17.
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

    public String toString(){
        return userType;
    }
}
