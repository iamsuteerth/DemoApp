package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity; //For compatibility

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { //public means it can be accessed anywhere in the app
//Main activity class will take the code for app compat activity
    String uname="drbullah";
    String pswd="abcd12345";
    public void clickFunction(View view){
        EditText mytf = (EditText) findViewById(R.id.username); //Type Casting
        EditText myps = (EditText) findViewById(R.id.pswd);
        Log.i("Info","Username "+mytf.getText().toString()+
                " "+"Password "+myps.getText().toString());
        if (mytf.getText().toString().equals(uname) && myps.getText().toString().equals(pswd))
        {
            Toast.makeText(this, "Welcome Dr Bullah !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, pagetwo.class);
            startActivity(intent);
        } else {
            mytf.setText("");
            myps.setText("");
            Toast.makeText(this, "Please Try Again!", Toast.LENGTH_SHORT).show();
        }
        }


    @Override //Customising onCreate, that is adding code to that method and we are just adding some code
    protected void onCreate(Bundle savedInstanceState) { //When activity is created or run and protected means that only this package can access it
        super.onCreate(savedInstanceState); //void means the method doesn't return anything
        //save state means it will restore it
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main); //Resources, Layout, Activity Main XML file
    }
}