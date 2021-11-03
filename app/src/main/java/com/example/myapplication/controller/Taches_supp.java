package com.example.myapplication.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.model.Grosse_list;
import com.example.myapplication.model.List_rubriques;
import com.example.myapplication.model.Taches;
import com.example.myapplication.tools.Animation_;
import com.example.myapplication.view.List_taches_process;

public class Taches_supp extends AppCompatActivity {
    private ImageView supp_tache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taches_supp);


        this.supp_tache = findViewById(R.id.imageView_supp_article);

        supp_tache.setOnClickListener(view -> {

            RotateAnimation anim = Animation_.RotateAnimation();

            supp_tache.setAnimation(anim);


            Intent intent = new Intent(getApplicationContext(), List_taches_process.class);
            startActivity(intent);



            for (List_rubriques rubriques : Grosse_list.universal_list) {
                if (rubriques.isValide()) {
                    for (Taches tache : rubriques.getList_taches()) {
                        if (tache.isValide()) {
                            rubriques.getList_taches().remove(tache.getId());
                           finish();
                        }


                    }

                }
            }
        });


    }
}