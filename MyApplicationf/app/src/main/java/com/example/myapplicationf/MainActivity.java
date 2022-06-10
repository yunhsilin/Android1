package com.example.myapplicationf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity  {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Spinner spinner= findViewById(R.id.label_spinner);
//        if(spinner!=null){
//            spinner.setOnItemClickListener((AdapterView.OnItemClickListener) this);
//        }
//        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.videos_array, android.R.layout.simple_spinner_dropdown_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        if(spinner!=null){
//            spinner.setAdapter(adapter);
//        }
//        Intent intent=getIntent();
////        String message=intent.getDataString();
//        TextView textview=findViewById(R.id.message);
////        textview.setText(message);
//    }
//
//    public void displayToast(String message){
//        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
//    }
//
//    public void inItemSelect(AdapterView<?> parent, View view, int position, long id){
//        String spinnerLabel=parent.getItemAtPosition(position).toString();
//        displayToast(spinnerLabel);
//    }
//
////    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//        Log.i("GTOUTOUT", "Nothing Selected");
//    }

    private VideoView video;
    private String[] videoFile = {"vivi2", "vivi3", "wildlife"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = getApplicationContext();
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.label_spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.videos_array, android.R.layout.simple_spinner_item);

//        video = (VideoView)findViewById(R.id.videoView);
        // 指定影片的URI


        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //stuff here to handle item selection
//                Toast.makeText(this, getApplicationContext(), Toast.LENGTH_SHORT).show();
                Context context = getApplicationContext();
                video = (VideoView)findViewById(R.id.videoView);
                int index=spinner.getSelectedItemPosition();
                String aaindex;
                if(index==0){
                    aaindex="aa";
                }else if (index==1){
                    aaindex="bb";
                }else{
                    aaindex="cc";
                }
                Toast.makeText(context, aaindex , Toast.LENGTH_LONG).show();

                int idd = getResources().getIdentifier(videoFile[index], "raw", "com.example.myapplicationf");
                final String path = "android.resource://com.example.myapplicationf" + "/" + idd;
                video.setVideoURI(Uri.parse(path));
                // 指定MediaController
                video.setMediaController(new MediaController(MainActivity.this));
                video.start(); // 開始播放


            }


//            private String getPackageName() {
//                return this.getPackageName();
//            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                Log.i("GTOUTOUT", "Nothing Selected");
            }
        });



    }

//    @Override
//    public void onPause() {
//        super.onStop();
//        video.stopPlayback();  // 停止播放
//    }
}