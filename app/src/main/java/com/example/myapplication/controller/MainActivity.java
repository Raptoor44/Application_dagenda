package com.example.myapplication.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.model.Grosse_list;
import com.example.myapplication.model.List_rubriques;
import com.example.myapplication.tools.Serializer;
import com.example.myapplication.view.List_rubriques_process;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements Serializable {

    private Button creer_rubrique;
    private Button voir_rubrique;
    private Button save_data;
    private Button tout_supprimer;
    private String file_name = "Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.creer_rubrique = findViewById(R.id.creer_nouvelle_rubrique);
        this.voir_rubrique = findViewById(R.id.voir_rubriques);


        this.creer_rubrique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), Creation_rubrique.class);
                startActivity(otherActivity);

                finish();
            }
        });
        this.voir_rubrique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Grosse_list.universal_list.size() == 0) {


                    ArrayList<List_rubriques> list1 = new ArrayList<List_rubriques>();

                    list1 = (ArrayList<List_rubriques>) Serializer.deSerialize(file_name, getApplicationContext());
                    if (!list1.equals(null)) {
                        Grosse_list.universal_list = list1;
                    }


                    Intent otherActivity = new Intent(getApplicationContext(), List_rubriques_process.class);
                    startActivity(otherActivity);
                } else {
                    Intent otherActivity = new Intent(getApplicationContext(), List_rubriques_process.class);
                    startActivity(otherActivity);
                }
            }
        });

        this.save_data = findViewById(R.id.button_save_data);
        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Serializer.serialize(file_name, Grosse_list.universal_list, getApplicationContext());

            }
        });

        tout_supprimer = findViewById(R.id.button_tout_supprimer);

        tout_supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < Grosse_list.universal_list.size(); i++) {

                    Grosse_list.universal_list.get(i).setValide(false);
                    Grosse_list.universal_list.remove(i);
                    finish();

                }
            }
        });
    }


}