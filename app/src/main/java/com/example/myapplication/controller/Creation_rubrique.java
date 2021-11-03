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
import com.google.android.material.textfield.TextInputEditText;

public class Creation_rubrique extends AppCompatActivity {


    private Button creer_rubrique;
    private TextInputEditText nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_rubrique);


        this.creer_rubrique = findViewById(R.id.button_creer_rubrique);
        this.nom = findViewById(R.id.text_input_nom_rubrique);


        creer_rubrique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean is_valide = true;

                for (List_rubriques rubriques_nom : Grosse_list.universal_list) {
                    if (nom.getText().toString().equals(rubriques_nom.getNom().toString())) {

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Erreur, une rubrique possédant le même nom existe déjà, veuillez réessayez", Toast.LENGTH_LONG).show();
                        finish();
                        is_valide = false;
                    }
                }

                if (is_valide == true) {

                    List_rubriques list = new List_rubriques(nom.getText().toString());


                    Grosse_list.universal_list.add(list);


                    Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(otherActivity);

                    finish();
                }
            }
        });
    }
}