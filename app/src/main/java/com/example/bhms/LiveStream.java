package com.example.bhms;

import android.app.ProgressDialog;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;



public class LiveStream extends AppCompatActivity {

    VideoView video ;
    String video_url= "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_stream);

        video =(VideoView)findViewById(R.id.video_stream);
        String videoPath = "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4";
        Uri uri = Uri.parse(videoPath);
        video.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(video);
        video.setMediaController(mediaController);

        video.start();
    }
}