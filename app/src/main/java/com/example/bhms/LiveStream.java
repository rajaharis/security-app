package com.example.bhms;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;



public class LiveStream extends AppCompatActivity {

//    VideoView video ;
//    String video_url= "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_stream);

        VideoView videoView = (VideoView) findViewById(R.id.videoview);

        //Attach a media controller to video view
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        //add your video URL
        Uri  uri = Uri.parse("https://www.youtube.com/watch?v=90hWWAqfdUU&ab_channel=TechProgrammingIdeas");


        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}