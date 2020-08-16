package com.example.workout.Files;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.workout.Fragement.Arms;
import com.example.workout.Fragement.Fullbody;
import com.example.workout.Fragement.LoweBody;
import com.example.workout.Fragement.Lowerarea;
import com.example.workout.Home;
import com.example.workout.R;

import java.util.ArrayList;

public class Workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        ListView listView = findViewById(R.id.mylist);
        Button button = findViewById(R.id.btn1);

//        Yeta chai fragment ko kaam
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Fullbody fullbody = new Fullbody();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.mainfragment,fullbody).addToBackStack(null).commit();
                }
                if (position == 1){
                    LoweBody loweBody = new LoweBody();
                    FragmentManager fm = getSupportFragmentManager();
                    fm.beginTransaction().replace(R.id.mainfragment,loweBody).addToBackStack(null).commit();
                }
                if (position == 2){
                    Lowerarea lowerarea = new Lowerarea();
                    FragmentManager fml = getSupportFragmentManager();
                    fml.beginTransaction().replace(R.id.mainfragment,lowerarea).addToBackStack(null).commit();
                }
                if (position == 3){
                    Arms arms = new Arms();
                    FragmentManager fma = getSupportFragmentManager();
                    fma.beginTransaction().replace(R.id.mainfragment,arms).addToBackStack(null).commit();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Workout.this, Home.class);
                startActivity(intent);
            }
        });


//        /Array list
        ArrayList <String> names = new ArrayList<>();
        names.add("Fullbody");
        names.add("Lowerbody");
        names.add("LowerArea");
        names.add("Arms");

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,names);
        listView.setAdapter(adapter);
        }
    }

