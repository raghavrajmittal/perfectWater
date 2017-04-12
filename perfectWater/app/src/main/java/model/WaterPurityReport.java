package model;

import android.util.Log;

import com.example.thushara.perfectwater.Controller.HomeScreen;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * A water purity report class
 */

public class WaterPurityReport {

    private static ArrayList<WaterPurityReport> purity_reports;
    private static ArrayList<String> report;
    private String waterCondition;
    private String virusppm;
    private String contppm;
    private String name ;
    private String date;
    private String time;
    private String location;
    private static int num;

    public WaterPurityReport(String name, String date, String time, String location,
                             String waterCondition, String virusppm, String contppm) throws Exception{
        this.name = name;
        this.date = date;
        this.time = time;
        this.virusppm = virusppm;
        this.contppm = contppm;
        this.location = location;
        this.waterCondition = waterCondition.toString();
        this.num = num++;
        if (name.equals("") || date.equals("") || time.equals("") || location.equals("") ||
                virusppm.equals("") || waterCondition.equals("") || contppm.equals("")) {
            throw new Exception("all fields need to be filled to submit a report.");
        }
        if (purity_reports == null) {
            purity_reports = new ArrayList<>();
        }
        purity_reports.add(this);
        //Log.d("name", name);
    }

    static public ArrayList<WaterPurityReport> getReports() {
        return purity_reports;
    }

    public String getName() {
        return name;
    }
    public String getTime() {
        return time;
    }
    public String getDate() {
        return date;
    }
    public String getLocation() {
        return location;
    }
    public String getVirusppm() {
        return virusppm;
    }
    public String getWaterCondition() {
        return waterCondition;
    }
    public String getContppm() {
        return contppm;
    }



    public void writeToDatabase() {
        DatabaseReference purityReportDB = HomeScreen.getWaterPurityReportDatabase();
        purityReportDB.child(Integer.toString(num)).child("Name").setValue(name);
        purityReportDB.child(Integer.toString(num)).child("Date").setValue(date);
        purityReportDB.child(Integer.toString(num)).child("Water Condition").setValue(waterCondition);
        purityReportDB.child(Integer.toString(num)).child("Zip code").setValue(location);
        purityReportDB.child(Integer.toString(num)).child("Virus ppm").setValue(virusppm);
        purityReportDB.child(Integer.toString(num)).child("Cont ppm").setValue(contppm);
    }


    @Override
    public String toString() {
        String details = "Report Date: " + date + "Report Name: " + name + "Report location: " + location;
        return details;
    }
}
