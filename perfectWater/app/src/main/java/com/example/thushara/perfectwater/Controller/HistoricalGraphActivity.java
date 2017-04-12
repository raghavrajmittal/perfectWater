package com.example.thushara.perfectwater.Controller;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.thushara.perfectwater.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import model.WaterPurityReport;

import static java.lang.Integer.parseInt;

public class HistoricalGraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_graph);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        GraphView graph = (GraphView) findViewById(R.id.graph);
        WaterPurityReport one = null;
        try {
            one = new WaterPurityReport("name", "01", "time", "location", "clean", "112", "113");
        } catch (Exception e) {
            e.printStackTrace();
        }
        WaterPurityReport two = null;
        try {
            two = new WaterPurityReport("name", "02", "time", "location", "clean", "123", "113");
        } catch (Exception e) {
            e.printStackTrace();
        }
        WaterPurityReport three = null;
        try {
            three = new WaterPurityReport("name", "03", "time", "location", "clean", "200", "113");
        } catch (Exception e) {
            e.printStackTrace();
        }
        WaterPurityReport four = null;
        try {
            four = new WaterPurityReport("name", "04", "time", "location", "clean", "250", "113");
        } catch (Exception e) {
            e.printStackTrace();
        }
        WaterPurityReport five = null;
        try {
            five = new WaterPurityReport("name", "05", "time", "location", "clean", "300", "113");
        } catch (Exception e) {
            e.printStackTrace();
        }
        WaterPurityReport six = null;
        try {
            six = new WaterPurityReport("name", "06", "time", "location", "clean", "400", "113");
        } catch (Exception e) {
            e.printStackTrace();
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(parseInt(one.getDate()), parseInt(one.getVirusppm())),
                new DataPoint(parseInt(two.getDate()), parseInt(two.getVirusppm())),
                new DataPoint(parseInt(three.getDate()), parseInt(three.getVirusppm())),
                new DataPoint(parseInt(four.getDate()), parseInt(four.getVirusppm())),
                new DataPoint(parseInt(five.getDate()), parseInt(five.getVirusppm())),
                new DataPoint(parseInt(six.getDate()), parseInt(six.getVirusppm())),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        graph.addSeries(series);
        series.setTitle("Random Curve 1");
        series.setColor(Color.GREEN);
        graph.setBackgroundColor(Color.LTGRAY);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(16);
        series.setThickness(12);
        // set manual X bounds
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(7);

        // set manual Y bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(100);
        graph.getViewport().setMaxY(420);
        graph.setTitle("Historical Reports");
    }

}
