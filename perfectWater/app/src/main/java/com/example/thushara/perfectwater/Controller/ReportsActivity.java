package com.example.thushara.perfectwater.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.thushara.perfectwater.R;

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //Report button functionality
        Button viewReports_button = (Button) findViewById(R.id.view_water_source_reports);
        viewReports_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReportsActivity.this, ReportsListActivity.class));
            }
        });

        //Add Report Button functionality
        Button addReports_button = (Button) findViewById(R.id.add_water_source_report);
        addReports_button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                startActivity(new Intent(ReportsActivity.this, WaterSourceReportActivity.class));
            }
        });

        Button addPurityReport_button = (Button) findViewById(R.id.add_water_purity_report);
        addPurityReport_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReportsActivity.this, WaterPurityReportActivity.class));
            }
        });

        Button viewPurityReport_button = (Button) findViewById(R.id.view_purity_reports);
        viewPurityReport_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReportsActivity.this, PurityListActivity.class));
            }
        });

        Button graph_button = (Button) findViewById(R.id.historical_report);
        graph_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReportsActivity.this, HistoricalGraphActivity.class));
            }
        });

        //home button functionality
        Button home_screen = (Button) findViewById(R.id.report_screen_home_screen_button);
        home_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReportsActivity.this, HomeScreen.class));
            }
        });



    }

}
