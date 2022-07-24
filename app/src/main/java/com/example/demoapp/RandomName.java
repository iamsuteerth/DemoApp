package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomName extends AppCompatActivity {
    EditText input;
    ImageView reset;
    Button feeder;
    Button popper;
    Button execute;
    ListView listView;
    TextView winner;
    int key;
    List names = new ArrayList<String>() ;
    ArrayAdapter<String> adapter; //Holds the data that listview will display

    public void onBackPressed() {
        finish();
    }
    private void makeToast(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
    public void addName(String n){
        names.add(n);
        listView.setAdapter(adapter);
    }
    public void removeNameNoInput(){
        makeToast("Removed "+names.get((int)names.size()-1).toString()+" !");
        names.remove(names.size()-1);
        adapter.notifyDataSetChanged();
        //Aliter:listview.setAdapter(adapter);
    }
    public void removeName(int removed){
        names.remove(removed);
        adapter.notifyDataSetChanged();
    }
    public void pickRandomName(View view){
        if(names.size()!=0) {
            Random rand = new Random();
            key = rand.nextInt((int) names.size());
            for (int i = 0; i < names.size(); i++) {
                if (names.get(i) == names.get(key)) {
                    winner.setText(names.get(key).toString());
                }
            }
        }
    }
    public void resetSwitch(View view){
        names.clear();
        adapter.notifyDataSetChanged();
        winner.setText("");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_random_name);

        listView = findViewById(R.id.listview);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);
        input = (EditText) findViewById(R.id.entername);
        reset = (ImageView) findViewById(R.id.reset);
        feeder = (Button) findViewById(R.id.feeder);
        popper = (Button) findViewById(R.id.popper);
        execute = (Button) findViewById(R.id.picker);
        winner = (TextView) findViewById(R.id.winner);

        feeder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                if(text == null || text.length() == 0){
                    makeToast("Enter a proper name!");
                } else {
                    addName(text);
                    input.setText("");
                    makeToast("Added "+text);
                }
            }
        });
        popper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeNameNoInput();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                makeToast("Removed "+names.get(i));
                removeName(i);
                return false;
            }
        });
    }
}