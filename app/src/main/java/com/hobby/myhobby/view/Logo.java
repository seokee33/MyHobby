package com.hobby.myhobby.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.hobby.myhobby.R;

public class Logo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myStartActivity(MainActivity.class);
            }
        },2500);
    }

    private void myStartActivity(Class activity){
        Intent intent = new Intent(this,activity);
        finish();
        startActivity(intent);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }
}
