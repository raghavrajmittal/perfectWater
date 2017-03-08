package com.example.thushara.perfectwater.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.thushara.perfectwater.R;

import java.util.ArrayList;

import model.WaterSourceReport;


public class ReportsListActivity extends AppCompatActivity {

    private ArrayList<model.WaterSourceReport> items;
    private ArrayList<String> details = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        WaterSourceReport one = new WaterSourceReport("diane", "1/2/3", "12:34", "ga", "spring", "waste");
      //  items.add(one);
        items = WaterSourceReport.getReports();
        //Bundle extras = getIntent().getExtras();
       // items = (ArrayList) extras.getSerializable("report list");
        Log.d("reports", items.get(0).toString());
        for (int i = 0; i < items.size(); i++) {
            details.add(items.get(i).toString());
            Log.d("item", items.get(i).toString());
        }

        ListView listview = (ListView) findViewById(R.id.reports_list_view);
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.list_entry,details);
        listview.setAdapter(adapter);
    }


}
