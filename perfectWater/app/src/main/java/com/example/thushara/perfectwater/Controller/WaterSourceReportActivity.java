package com.example.thushara.perfectwater.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.thushara.perfectwater.R;

import model.WaterCondition;
import model.WaterSourceReport;
import model.WaterType;


public class WaterSourceReportActivity extends AppCompatActivity {
    private Spinner watertype;
    private Spinner condition;
    private TextView nameo ;
    private TextView dateo;
    private TextView timeo;
    private TextView locationo;
    private String waterCondition;
    private String waterType;
    private String name ;
    private String date;
    private String time;
    private String location;
    //private ArrayList info = new ArrayList(Arrays.asList(number, name.toString(), waterType.toString(),
            //date.toString(), time.toString(), location.toString(), waterType.toString()));


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_source_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
              * Grab the dialog widgets so we can get info for later
              */

        nameo = (TextView) findViewById(R.id.name);
        dateo = (TextView) findViewById(R.id.date);
        timeo = (TextView) findViewById(R.id.time);
        locationo = (TextView) findViewById(R.id.location);


       setContentView(R.layout.activity_water_source_report);
       //loads the spinners and sets the values in it
       watertype = (Spinner) findViewById(R.id.waterTypeSpinner);
       ArrayAdapter<WaterType> waterTypeAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, WaterType.values());
       waterTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       watertype.setAdapter(waterTypeAdapter);

       condition = (Spinner) findViewById(R.id.waterConditionSpinner);
       ArrayAdapter<WaterCondition> waterConditionAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, WaterCondition.values());
       waterConditionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       condition.setAdapter(waterConditionAdapter);



        //cancel profile button functionality
       Button cancel_button = (Button) findViewById(R.id.cancel_source_report_button);
       cancel_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              startActivity(new Intent(WaterSourceReportActivity.this, HomeScreen.class));
              }
           });
       //Submit Report Button
        Button submit_button = (Button) findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameo.getText().toString();
                date = dateo.getText().toString();
                time = timeo.getText().toString();
                location = locationo.getText().toString();
                waterType = watertype.getSelectedItem().toString();
                waterCondition = condition.getSelectedItem().toString();
                WaterSourceReport report = new WaterSourceReport(name, date, time, location, waterType, waterCondition);
                startActivity(new Intent(WaterSourceReportActivity.this, ReportsActivity.class));

            }
        });


    }


}