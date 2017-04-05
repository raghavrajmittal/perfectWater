package com.example.thushara.perfectwater.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import com.example.thushara.perfectwater.R;

import java.util.ArrayList;

import model.UserType;

public class RegistrationActivity extends AppCompatActivity {

    private Spinner userTypeSpinner;
    private ArrayList<String> registered_Users;

    private Spinner userType;
    private TextView name ;
    private TextView username;
    private TextView password;
    private ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
    private ArrayList<String> info = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Grab the dialog widgets so we can get info for later
         */
        //loads the spinners and sets the values in it
        userTypeSpinner = (Spinner) findViewById(R.id.usertypeSpinner);
        ArrayAdapter<UserType> userTypeAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, UserType.values());
        userTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userTypeSpinner.setAdapter(userTypeAdapter);

        Button registrationButton = (Button) findViewById(R.id.registration_button);
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register_new_user();
                startActivity(new Intent(RegistrationActivity.this, HomeScreen.class));
                finish();
            }
        });

        Button cancelButton = (Button) findViewById(R.id.cancel_registration);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clear_fields();
                finish();
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });
    }

    // functionality when the "register" button is clicked
    private boolean register_new_user(){
        name = (EditText) findViewById(R.id.register_name);
        username = (EditText) findViewById(R.id.register_username);
        password = (EditText) findViewById(R.id.register_password);
        userType = (Spinner) findViewById(R.id.usertypeSpinner);
        info.add(name.getText().toString());
        info.add(username.getText().toString());
        info.add(password.getText().toString());
        records.add(info);

        return true;
    }

/*
     *//**
     * Clears all the fields of the fields on the registration screen
     *//*
    private void clear_fields(){
        EditText nameView = (EditText) findViewById(R.id.register_name);
        AutoCompleteTextView usernameView = (AutoCompleteTextView) findViewById(R.id.register_username);
        EditText passwordView = (EditText) findViewById(R.id.register_password);

        Spinner userTypeView = (Spinner) findViewById(R.id.user_typeSpinner);

        nameView.setText("");
        usernameView.setText("");
        passwordView.setText("");

    }*/

}
