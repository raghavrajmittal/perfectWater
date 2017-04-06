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
import com.google.firebase.database.DatabaseReference;

import model.WaterCondition;
import model.WaterPurityReport;
import model.WaterSourceReport;
import model.WaterType;

public class WaterPurityReportActivity extends AppCompatActivity {

    private Spinner condition;
    private TextView name_tv ;
    private TextView date_tv;
    private TextView time_tv;
    private TextView location_tv;
    private TextView virus_ppm_tv;
    private TextView cont_ppm_tv;

    private String waterCondition;
    private String name ;
    private String date;
    private String time;
    private String location;
    private String virus_ppm;
    private String cont_ppm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_purity_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name_tv = (TextView) findViewById(R.id.name1);
        date_tv = (TextView) findViewById(R.id.date1);
        time_tv = (TextView) findViewById(R.id.time1);
        location_tv = (TextView) findViewById(R.id.location1);
        virus_ppm_tv = (TextView) findViewById(R.id.virusppm);
        cont_ppm_tv = (TextView) findViewById(R.id.contaminantppm);


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
        //Submit Report Button --> takes you to main screen with reports
        Button submit_button = (Button) findViewById(R.id.submit_button1);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = name_tv.getText().toString();
                date = date_tv.getText().toString();
                time = time_tv.getText().toString();
                location = location_tv.getText().toString();
                virus_ppm = virus_ppm_tv.getText().toString();
                cont_ppm = cont_ppm_tv.getText().toString();
                waterCondition = condition.getSelectedItem().toString();
                WaterPurityReport report = createWaterPurityReport(name, date, time, location, waterCondition, virus_ppm, cont_ppm);
//                WaterPurityReport report = new WaterPurityReport(name, date, time, location, waterCondition, virus_ppm, cont_ppm);
                finish();
                startActivity(new Intent(WaterPurityReportActivity.this, PurityListActivity.class));

            }
        });
    }

    private WaterPurityReport createWaterPurityReport(String name, String date, String time, String location, String waterCondition, String virus_ppm, String cont_ppm){
        WaterPurityReport report = new WaterPurityReport(name, date, time, location, waterCondition, virus_ppm, cont_ppm);
        return report;
    }

}
