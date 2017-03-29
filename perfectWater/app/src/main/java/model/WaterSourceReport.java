package model;

import android.util.Log;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.thushara.perfectwater.Controller.WaterSourceReportActivity;

import java.util.ArrayList;

/**
 * Created by deepapillalamarri on 3/8/17.
 */

public class WaterSourceReport {
    private static ArrayList<WaterSourceReport> allReports;
    private static ArrayList<String> report;
    private String waterCondition;
    private String waterType;
    private String name ;
    private String date;
    private String time;
    private String location;
    private static int num;

    /**
     * creates WaterSourceReport object with name, date, time, location, watertype and watercondition
     * @param name name of user
     * @param date date report is being filed
     * @param time time report is being filed
     * @param location location report is indicating
     * @param waterType what kind of water
     * @param waterCondition condition of water
     */

    public WaterSourceReport(String name, String date, String time, String location, String waterType, String waterCondition) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.waterType = waterType.toString();
        this.waterCondition = waterCondition.toString();
        this.num = num++;
        if (allReports == null) {
            allReports = new ArrayList<>();
        }
        allReports.add(this);
        Log.d("name", name);
    }

    /**
     * gets all the water reports
     * @return ArrayList of water source reports
     */

    static public ArrayList<WaterSourceReport> getReports() {
        return allReports;
    }


    @Override
    public String toString() {
        String details = "Report Date: " + date + "Report Name: " + name + "Report location: " + location;
        return details;
    }


}
