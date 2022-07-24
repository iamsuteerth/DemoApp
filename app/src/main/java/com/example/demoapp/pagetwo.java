package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class pagetwo extends AppCompatActivity {

    public void hlowGame(View view){
        Intent intent = new Intent(this, HighLow.class);
        startActivity(intent);
    }
    public void randNameGame(View view){
        Intent intent = new Intent(this, RandomName.class);
        startActivity(intent);
    }

    public void onBackPressed() {
        finish();
    }
    private int activeState; //0 is for cheems and 1 is for bonk
    public void transform(View view){
        ImageView img = (ImageView) findViewById(R.id.doge);
        if (activeState == 0){
            img.setImageResource(R.drawable.bonk);
            activeState = 1;
        }
        else {
            img.setImageResource(R.drawable.cheems);
            activeState = 0;
        }

    }
    public void reset(View view){
        ImageView img = (ImageView) findViewById(R.id.doge);
        img.setImageResource(0);
        activeState=0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.pagetwo);
    }
}