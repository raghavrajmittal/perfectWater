package model;

import android.util.Log;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.thushara.perfectwater.Controller.HomeScreen;
import com.example.thushara.perfectwater.Controller.WaterSourceReportActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * A water source report class
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
     * creates WaterSourceReport object with name, date, time, location, water type and water condition
     * @param name name of user
     * @param date date report is being filed
     * @param time time report is being filed
     * @param location location report is indicating
     * @param waterType what kind of water
     * @param waterCondition condition of water
     */

    public WaterSourceReport(String name, String date, String time, String location, String waterType, String waterCondition) throws Exception{
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.waterType = waterType.toString();
        this.waterCondition = waterCondition.toString();
        this.num = num++;
        if (name.equals("") || date.equals("") || time.equals("") || location.equals("") ||
                waterType.equals("") || waterCondition.equals("")) {
            throw new Exception("all fields need to be filled to submit a report.");
        }
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

    public void writeToDatabase() {
        DatabaseReference sourceReportDB = HomeScreen.getWaterSourceReportDatabase();
        sourceReportDB.child(Integer.toString(num)).child("Name").setValue(name);
        sourceReportDB.child(Integer.toString(num)).child("Date").setValue(date);
        sourceReportDB.child(Integer.toString(num)).child("Water Type").setValue(waterType);
        sourceReportDB.child(Integer.toString(num)).child("Water Condition").setValue(waterCondition);
        sourceReportDB.child(Integer.toString(num)).child("Zipcode").setValue(location);
    }


}
