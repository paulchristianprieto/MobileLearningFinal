package com.paul.mobilelearning;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Objects;

public class Videos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        Intent i = getIntent();
        String activeVideoName = i.getStringExtra("videoName");
        String term = i.getStringExtra("term");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(activeVideoName);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);


        if(Objects.equals(activeVideoName, "CARIÑOSA")){

            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.carinosa);
            //Intent intent = new Intent(null, Uri.parse("https://www.youtube.com/watch?v=UjU1QDKetiQ"), this, Videos.class);
            //startActivity(intent);

            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
            videoView.start();

        }else if(Objects.equals(activeVideoName, "LA-WALK")){

            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.la_walk);
            //Intent intent = new Intent(null, Uri.parse("https://www.youtube.com/watch?v=UjU1QDKetiQ"), this, Videos.class);
            //startActivity(intent);

            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
            videoView.start();

        }else if(Objects.equals(activeVideoName, "CHA CHA CHA")){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=PWiLi22Cq8w")));
        }else if(Objects.equals(activeVideoName, "TIKLOS")){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=UjU1QDKetiQ")));
        }else if(Objects.equals(activeVideoName, "SWING")){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Yfd5du3ULas")));
        }else if(Objects.equals(activeVideoName, "REGGAE")){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=66zTWwJ-v6A")));
        }else if(Objects.equals(activeVideoName, "INTERPRETATIVE DANCE")){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Oqn8FgEBKMg")));
        }else if(Objects.equals(activeVideoName, "HIPHOP")){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=8nShaD_5U0k")));
        }


    }
}
