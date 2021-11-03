package com.example.myapplication.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.model.Grosse_list;
import com.example.myapplication.model.List_rubriques;
import com.example.myapplication.model.Taches;
import com.example.myapplication.view.List_taches_process;

public class Taches_controller extends AppCompatActivity {


    private Button button_list;
    private Button button_ajouter_tache;
    private ImageView supp_tache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taches_controller);


        this.button_ajouter_tache = findViewById(R.id.button_acceder_nouvelle_taches);
        button_ajouter_tache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Creation_taches.class);
                startActivity(intent);


            }
        });

        this.button_list = findViewById(R.id.button_accéder_list_taches);
        button_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), List_taches_process.class);
                startActivity(intent);

            }
        });




        this.supp_tache = findViewById(R.id.imageview_supp_in_tache);

        supp_tache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

           for(List_rubriques rubriques : Grosse_list.universal_list){
               if(rubriques.isValide()){
                   Grosse_list.universal_list.remove(rubriques);
                   finish();
               }
           }
            }

        });
    }
}