package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.model.Custom_list_taches_adapter;

import com.example.myapplication.controller.Taches_supp;
import com.example.myapplication.model.Grosse_list;
import com.example.myapplication.model.List_rubriques;
import com.example.myapplication.model.Taches;

public class List_taches_process extends AppCompatActivity {

    private ListView taches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_taches_process);

        this.taches = findViewById(R.id.list_view_TACHES);


        for (List_rubriques rubriques : Grosse_list.universal_list) {
            if (rubriques.isValide()) {


            Custom_list_taches_adapter adapter  = new Custom_list_taches_adapter(this ,
                    rubriques);
            ListView list = findViewById(R.id.list_view_TACHES);
            list.setAdapter(adapter);
            }
        }
        taches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Taches_supp.class);
                startActivity(intent);

                for (List_rubriques rubriques : Grosse_list.universal_list) {
                    if (rubriques.isValide()) {
                        for (Taches tache : rubriques.getList_taches()) {
                            if (position == tache.getId()) {
                                tache.setValide(true);
                            }


                        }

                    }
                }


            }
        });

    }

    private void false_taches() {


        for (List_rubriques rubriques : Grosse_list.universal_list) {
            if (rubriques.isValide()) {
                for (Taches tache : rubriques.getList_taches()) {
                    tache.setValide(false);

                }

            }
        }
    }

}