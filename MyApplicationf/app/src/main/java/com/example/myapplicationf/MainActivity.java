package com.example.myapplicationf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
    private String[] videoFile = {"catisland", "shibainu", "dog", "france", "husky", "mesocricetusauratus", "snow", "surfingcat", "sweden", "tencm", "watercat", "wildlife"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = getApplicationContext();
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.label_spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.videos_array, android.R.layout.simple_expandable_list_item_1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.spinner_style, R.array.videos_array);
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
                    aaindex="catisland";
                }else if(index==1){
                    aaindex="shibainu";
                }else if (index==2){
                    aaindex="dog";
                }else if (index==3){
                    aaindex="france";
                }else if (index==4){
                    aaindex="husky";
                }else if (index==5){
                    aaindex="mesocricetusauratus";
                }else if (index==6){
                    aaindex="snow";
                }else if (index==7){
                    aaindex="surfingcat";
                }else if (index==8){
                    aaindex="sweden";
                }else if (index==9){
                    aaindex="tencm";
                }else if (index==10){
                    aaindex="watercat";
                }else{
                    aaindex="wildlife";
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

    @Override
    public void onPause() {
        super.onStop();
        video.stopPlayback();  // 停止播放
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }


    /**
     * Handles options menu item clicks.
     *
     * @param item The item that was pressed
     * @return returns true since the item click wa handled
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Check if the correct item was clicked.
        if (item.getItemId() == R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            // Set the theme mode for the restarted activity.
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            // Recreate the activity for the theme change to take effect.
            recreate();
        }
        return true;
    }
}