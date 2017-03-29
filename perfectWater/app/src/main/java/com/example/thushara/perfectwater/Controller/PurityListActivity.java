package com.example.thushara.perfectwater.Controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.thushara.perfectwater.R;

import java.util.ArrayList;

import model.WaterPurityReport;
import model.WaterSourceReport;

public class PurityListActivity extends AppCompatActivity {

    private ArrayList<WaterPurityReport> items;
    private ArrayList<String> details = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        WaterPurityReport one = new WaterPurityReport("diane", "1/2/3", "12:34", "ga", "safe", "112", "500");
        WaterPurityReport two = new WaterPurityReport("deepa", "1/2/3", "12:34", "ga", "safe", "220", "400");
        //items.add(one);
        //items.add(two);
        items = WaterPurityReport.getReports();
        //Bundle extras = getIntent().getExtras();
        // items = (ArrayList) extras.getSerializable("report list");
        Log.d("reports", items.get(0).toString());
        for (int i = 0; i < items.size(); i++) {
            details.add(items.get(i).toString());
            Log.d("item", items.get(i).toString());
        }

        ListView listview = (ListView) findViewById(R.id.purity_reports_list_view);
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.puritylistentry,details);
        listview.setAdapter(adapter);

    }

}
