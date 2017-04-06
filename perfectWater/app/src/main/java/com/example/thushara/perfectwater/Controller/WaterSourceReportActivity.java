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
import com.google.firebase.database.DatabaseReference;

import model.WaterCondition;
import model.WaterSourceReport;
import model.WaterType;


public class WaterSourceReportActivity extends AppCompatActivity {
    private Spinner water_type;
    private Spinner condition;
    private TextView name_tv ;
    private TextView date_tv;
    private TextView time_tv;
    private TextView location_tv;
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

        name_tv = (TextView) findViewById(R.id.name);
        date_tv = (TextView) findViewById(R.id.date);
        time_tv = (TextView) findViewById(R.id.time);
        location_tv = (TextView) findViewById(R.id.location);


        setContentView(R.layout.activity_water_source_report);
        //loads the spinners and sets the values in it
        water_type = (Spinner) findViewById(R.id.waterTypeSpinner);
        ArrayAdapter<WaterType> waterTypeAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, WaterType.values());
        waterTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        water_type.setAdapter(waterTypeAdapter);

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
                name = name_tv.getText().toString();
                date = date_tv.getText().toString();
                time = time_tv.getText().toString();
                location = location_tv.getText().toString();
                waterType = water_type.getSelectedItem().toString();
                waterCondition = condition.getSelectedItem().toString();
                WaterSourceReport report = new WaterSourceReport(name, date, time, location, waterType, waterCondition);
                finish();
                startActivity(new Intent(WaterSourceReportActivity.this, ReportsListActivity.class));

            }
        });

    }

}