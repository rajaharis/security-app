package com.example.bhms;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#0655bf"));
        getSupportActionBar().setTitle("Home");
        actionBar.setBackgroundDrawable(colorDrawable);
    }

    public void LiveStream(View view) {
        Intent intent = new Intent(HomeScreen.this, LiveStream.class);
        startActivity(intent);
    }

    public void IntruderImage(View view) {
        Intent intent = new Intent(HomeScreen.this, IntruderImage.class);
        startActivity(intent);
    }
}