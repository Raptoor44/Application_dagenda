package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.controller.MainActivity;
import com.example.myapplication.controller.Taches_controller;
import com.example.myapplication.model.Custom_list_rubriques_adapter;
import com.example.myapplication.model.Custom_list_taches_adapter;
import com.example.myapplication.model.Grosse_list;
import com.example.myapplication.model.List_rubriques;

import org.json.JSONException;

import java.util.Collections;
import java.util.List;

public class List_rubriques_process extends AppCompatActivity {

    private ListView rubriques;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_rubriques_process);

        //ZONE DE TEST


        //ZONE DE TEST
        false_rubrique();

        final ListView listView = (ListView) findViewById(R.id.rubriques_list_view);


        Custom_list_rubriques_adapter adapter = new Custom_list_rubriques_adapter(this,
                Grosse_list.universal_list);
        ListView list = findViewById(R.id.rubriques_list_view);
        list.setAdapter(adapter);
        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Taches_controller.class);
                startActivity(intent);
                for (List_rubriques rubriques : Grosse_list.universal_list) {

                    if (rubriques.getV_id() == position) {
                        rubriques.setValide(true);
                    }

                }
                finish();

            }
        });
    }

    private void false_rubrique() {
        for (List_rubriques rubriques : Grosse_list.universal_list) {
            rubriques.setValide(false);
        }
    }

}