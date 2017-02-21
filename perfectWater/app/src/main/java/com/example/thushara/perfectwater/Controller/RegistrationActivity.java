package com.example.thushara.perfectwater.Controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.thushara.perfectwater.R;

import model.UserType;

public class RegistrationActivity extends AppCompatActivity {

    private Spinner userTypeSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userTypeSpinner = (Spinner) findViewById(R.id.usertypeSpinner);

        ArrayAdapter<UserType> userTypeAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, UserType.values());
        userTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userTypeSpinner.setAdapter(userTypeAdapter);
    }

}
