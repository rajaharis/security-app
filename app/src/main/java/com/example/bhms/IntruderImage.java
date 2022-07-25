package com.example.bhms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
public class IntruderImage extends AppCompatActivity {

    ImageView imageView;
    String url = "http://192.168.100.9:5000/intruder/unknown.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intruder_image);


        imageView = findViewById(R.id.intruderImage);
        loadImage(url);
    }

    private void loadImage(String url) {
        Picasso.get()
                .load(url)
                .into(imageView);
    }
}