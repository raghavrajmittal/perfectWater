package com.example.thushara.perfectwater.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.thushara.perfectwater.R;

import model.WaterCondition;
import model.WaterPurityReport;
import model.WaterSourceReport;
import model.WaterType;

public class WaterPurityReportActivity extends AppCompatActivity {

    private Spinner condition;
    private TextView nameo ;
    private TextView dateo;
    private TextView timeo;
    private TextView locationo;
    private TextView virusppmo;
    private TextView contppmo;

    private String waterCondition;
    private String name ;
    private String date;
    private String time;
    private String location;
    private String virusppm;
    private String contppm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_purity_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
              * Grab the dialog widgets so we can get info for later
              */

        nameo = (TextView) findViewById(R.id.name1);
        dateo = (TextView) findViewById(R.id.date1);
        timeo = (TextView) findViewById(R.id.time1);
        locationo = (TextView) findViewById(R.id.location1);
        virusppmo = (TextView) findViewById(R.id.virusppm);
        contppmo = (TextView) findViewById(R.id.contaminantppm);


        setContentView(R.layout.activity_water_purity_report);


        condition = (Spinner) findViewById(R.id.waterConditionSpinner1);
        ArrayAdapter<WaterCondition> waterConditionAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, WaterCondition.values());
        waterConditionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        condition.setAdapter(waterConditionAdapter);



        //cancel profile button functionality
        Button cancel_button = (Button) findViewById(R.id.cancel_purity_report_button);
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WaterPurityReportActivity.this, HomeScreen.class));
            }
        });
        //Submit Report Button
        Button submit_button = (Button) findViewById(R.id.submit_button1);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameo.getText().toString();
                date = dateo.getText().toString();
                time = timeo.getText().toString();
                location = locationo.getText().toString();
                virusppm = virusppmo.getText().toString();
                contppm = contppmo.getText().toString();
                waterCondition = condition.getSelectedItem().toString();
                WaterPurityReport report = new WaterPurityReport(name, date, time, location, waterCondition, virusppm, contppm);
                startActivity(new Intent(WaterPurityReportActivity.this, ReportsActivity.class));

            }
        });
    }
}
