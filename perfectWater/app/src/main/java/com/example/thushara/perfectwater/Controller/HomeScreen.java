package com.example.thushara.perfectwater.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.thushara.perfectwater.R;

import android.util.Log;
import android.widget.ImageButton;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * Home screen activity that contains firebase login and buttons for all the functionality
 */
public class HomeScreen extends AppCompatActivity {
    private static final int RC_SIGN_IN = 0;
    private static FirebaseAuth auth;
    private static DatabaseReference userDB;
    private static DatabaseReference waterPurityReportDB;
    private static DatabaseReference waterSourceReportDB;

    private static String user_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        List<AuthUI.IdpConfig> providers = new ArrayList<>();
        providers.add(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build());
        providers.add(new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build());
        providers.add(new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build());


        System.out.println("HOMESCREEN");
        auth = FirebaseAuth.getInstance();

        userDB = FirebaseDatabase.getInstance().getReference("Users");
        waterPurityReportDB = FirebaseDatabase.getInstance().getReference("Water Purity Reports");
        waterSourceReportDB = FirebaseDatabase.getInstance().getReference("Water Source Reports");
        if (auth.getCurrentUser() != null) {
            //user already signed in
            Log.d("AUTH", auth.getCurrentUser().getEmail());
            String user_id = auth.getCurrentUser().getUid();
//            setVisibility(userDB.child(user_id));
        } else {
            startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder().setProviders(
                            providers
                    )
                    .build(), RC_SIGN_IN);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //logout button functionality
        Button logout_button = (Button) findViewById(R.id.home_screen_log_out_button);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUI.getInstance().signOut(HomeScreen.this).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        finish();
                    }
                });
//                finish();
//                startActivity(new Intent(HomeScreen.this, LoginActivity.class));
            }
        });

        //Edit Profile button functionality (actually goes to registration activity)
        ImageButton edit_profile_button = (ImageButton) findViewById(R.id.home_screen_edit_profile_button);
        edit_profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, RegistrationActivity.class));
            }
        });

        //Report button functionality
        ImageButton reports_button = (ImageButton) findViewById(R.id.home_screen_water_report_button);
        reports_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, ReportsActivity.class));
            }
        });

        //Google Maps button functionality
        ImageButton water_avail_map = (ImageButton) findViewById(R.id.home_screen_water_map_button);
        water_avail_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, MapsActivity.class));
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if(resultCode == RESULT_OK) {
                //user logged in
                Log.d("AUTH", auth.getCurrentUser().getEmail());
            } else {
                // user not authenticated
                Log.d("AUTH", "NOT AUTHENTICATED");
            }
        }
    }

    /*
     * @return user child from Firebase
     */
    public static DatabaseReference getUserDatabase(){
        return userDB;
    }


    public static DatabaseReference getWaterPurityReportDatabase(){
        return waterPurityReportDB;
    }


    public static DatabaseReference getWaterSourceReportDatabase(){
        return waterSourceReportDB;
    }

    public static FirebaseAuth getAuth() {
        return auth;
    }



//    private void setVisibility (DatabaseReference dbReference){
//        read(dbReference, new OnGetDataListener() {
//            @Override
//            public void onSuccess(DataSnapshot data_snap){
//                user_type = data_snap.child("usertype").getValue(String.class);
//            }
//        })
//    }

}
