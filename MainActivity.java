package com.example.ee.project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab_map;
    boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fab_map = (FloatingActionButton) findViewById(R.id.fab_map);

        fab_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LgnIntent = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(LgnIntent);
            }

        }
        );
    }

    @Override
    public void onBackPressed(){

        if (doubleBackToExitPressedOnce){
            finishAffinity();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan BACK Sekali Lagi untuk keluar", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                doubleBackToExitPressedOnce = false;
            }
        },2000);
    }}
