package com.paul.mobilelearning;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Lesson1 extends AppCompatActivity {

    TextView title;
    TextView content;
    TextToSpeech toSpeech;
    int result;
    String text;

    int txtSize = 14;
    TextView titlelesson1, c1,c2,c3,c4,c5,c6,c7, c8,c9,c10, c11,c12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);

        Intent lesson1 = getIntent();
        String activeLessonOrQuiz = lesson1.getStringExtra("lessonOrQuizName");
        String term = lesson1.getStringExtra("term");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Lesson 1");

        titlelesson1 = (TextView) findViewById(R.id.lessonOrQuizTitle);
        c1 = (TextView) findViewById(R.id.textView3);
        c2 = (TextView) findViewById(R.id.textView4);
        c3 = (TextView) findViewById(R.id.textView5);
        c4 = (TextView) findViewById(R.id.textView999);
        c5 = (TextView) findViewById(R.id.textView7);
        c6 = (TextView) findViewById(R.id.textView6123);
        c7 = (TextView) findViewById(R.id.textView679);
        c8 = (TextView) findViewById(R.id.textView67);
        c9 = (TextView) findViewById(R.id.textView6);
        c10 = (TextView) findViewById(R.id.textView6456);
        c11 = (TextView) findViewById(R.id.textView61235);
        c12 = (TextView) findViewById(R.id.textView61223);

        toSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    result = toSpeech.setLanguage(Locale.CANADA);
                } else {
                    Toast.makeText(getApplicationContext(), "Feature not supported in you device", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean dispatchKeyEvent(KeyEvent event){
        int action = event.getAction();
        int keyCode = event.getKeyCode();

        switch (keyCode) {

            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    if(txtSize < 36) {
                        txtSize += 2;
                        c1.setTextSize(txtSize);
                        c2.setTextSize(txtSize);
                        c3.setTextSize(txtSize);
                        c4.setTextSize(txtSize);
                        c5.setTextSize(txtSize);
                        c6.setTextSize(txtSize);
                        c7.setTextSize(txtSize);
                        c8.setTextSize(txtSize);
                        c9.setTextSize(txtSize);
                        c10.setTextSize(txtSize);
                        c11.setTextSize(txtSize);
                        c12.setTextSize(txtSize);
                    }
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    if (txtSize > 8) {
                        txtSize -= 2;
                        c1.setTextSize(txtSize);
                        c2.setTextSize(txtSize);
                        c3.setTextSize(txtSize);
                        c4.setTextSize(txtSize);
                        c5.setTextSize(txtSize);
                        c6.setTextSize(txtSize);
                        c7.setTextSize(txtSize);
                        c8.setTextSize(txtSize);
                        c9.setTextSize(txtSize);
                        c10.setTextSize(txtSize);
                        c11.setTextSize(txtSize);
                        c12.setTextSize(txtSize);
                    }
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    public void TTS1(View view) {
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            Toast.makeText(getApplicationContext(), "Feature not supported in you device", Toast.LENGTH_LONG).show();
        } else if (result == TextToSpeech.SUCCESS){
            if (toSpeech.isSpeaking()){
                toSpeech.stop();
            }else {
                text =  titlelesson1.getText().toString() + "."
                        + c1.getText().toString()
                        + c2.getText().toString()
                        + c3.getText().toString()
                        + c4.getText().toString()
                        + c5.getText().toString()
                        + c6.getText().toString()
                        + c7.getText().toString()
                        + c8.getText().toString()
                        + c9.getText().toString()
                        + c10.getText().toString()
                        + c11.getText().toString()
                        + c12.getText().toString();
                toSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(toSpeech!=null){
            toSpeech.stop();
            toSpeech.shutdown();
        }
    }


}
