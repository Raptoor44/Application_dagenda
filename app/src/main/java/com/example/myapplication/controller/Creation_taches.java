package com.example.myapplication.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.Grosse_list;
import com.example.myapplication.model.List_rubriques;
import com.example.myapplication.model.Taches;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Creation_taches extends AppCompatActivity {

    private Button ajouter;
    private TextInputEditText nom;
    private TextInputEditText descriptif;
    private TextInputEditText date;
    private Date date1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_taches);


        this.nom = findViewById(R.id.text_input_nom_taches);
        this.descriptif = findViewById(R.id.text_input_descriptif_tache);
        this.date = findViewById(R.id.Text_input_date_tache);


        this.ajouter = findViewById(R.id.button_tache_valider);

        ajouter.setOnClickListener(new View.OnClickListener() {
            boolean valide_ = false;
            boolean valide_2 = false;

            @Override
            public void onClick(View view) {
                try {
                    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date.getText().toString());
                    valide_ = true;
                } catch (ParseException e) {


                }
                if(descriptif.getText().length()<=200){
                    this.valide_2 = true;
                }

                if (valide_&&valide_2) {
                    String description = descriptif.getText().toString();
                    String nom_ = nom.getText().toString();


                    Taches tache = new Taches(description, date1, nom_);

                    for (List_rubriques rubriques : Grosse_list.universal_list) {
                        if (rubriques.isValide()) {
                            rubriques.getList_taches().add(tache);

                        }
                    }

                    Intent intent = new Intent(getApplicationContext(), Taches_controller.class);
                    startActivity(intent);
                    finish();


                } else {

                    Intent intent = new Intent(getApplicationContext(), Creation_taches.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Erreur, vous avez rentré un nombre trop important de caractères ou vous " +
                            "avez mal saisis la date", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });


    }


}