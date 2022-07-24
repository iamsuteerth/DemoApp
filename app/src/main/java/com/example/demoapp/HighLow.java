package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class HighLow extends AppCompatActivity {

    int key;
    int turn=0;
    public void makeToast(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    public void guess(View view){
        TextView status = (TextView) findViewById(R.id.status);
        EditText num = (EditText) findViewById(R.id.iofield);
        turn++;
        status.setText(Integer.toString(turn));
        if (Integer.parseInt(num.getText().toString()) > key) {
            makeToast("Lower!");
        }
        else if (Integer.parseInt(num.getText().toString()) < key)
        {
            makeToast("Higher!");
        } else if (Integer.parseInt(num.getText().toString()) == key) {
            makeToast("Great! Number was " + key + "You Took "+turn+" attempts!");
            Random rand = new Random();
            key=rand.nextInt(50)+1;
            turn=0;
            status.setText(Integer.toString(turn));
        }
    }
    public void onBackPressed() {
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_high_low);
        Random rand = new Random();
        key = rand.nextInt(50) +1;
    }
}