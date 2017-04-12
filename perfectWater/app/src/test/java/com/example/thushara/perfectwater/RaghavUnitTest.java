package com.example.thushara.perfectwater;

import org.junit.Test;

import model.User;
import model.UserType;
import java.lang.Exception;

import static org.junit.Assert.*;

/**
 * JUnit tests written by Raghav for testing the setName method in the User model class
 */
public class RaghavUnitTest{

    @Test
    public void nameisCorrect() throws Exception {
        User raghav = (User) new User("raghav", "30332", UserType.USER.toString());

        assertTrue(raghav.setName("Mittal"));
        assertTrue(raghav.setName("Raghav Mittal Jr."));
        assertTrue(raghav.setName("Raghav is really cool"));
        assertTrue(raghav.setName("raghavmittal"));

        assertFalse(raghav.setName("Raghav123"));
        assertFalse(raghav.setName("RAG1HAV"));
        assertFalse(raghav.setName("Raghav###"));
        assertFalse(raghav.setName("$monaayy$"));
        assertFalse(raghav.setName("123321"));

        assertFalse(raghav.setName(""));
        assertFalse(raghav.setName(null));
    }

}