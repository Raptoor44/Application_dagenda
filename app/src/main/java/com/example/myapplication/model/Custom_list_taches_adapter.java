package com.example.myapplication.model;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.StringRes;

import com.example.myapplication.R;
import com.example.myapplication.model.List_rubriques;
import com.example.myapplication.model.Taches;

import java.util.List;

public class Custom_list_taches_adapter extends BaseAdapter {


    private List<Taches> listData;
    private LayoutInflater layoutInflater;
    private Context context;


    public Custom_list_taches_adapter(Context aContext, List_rubriques list) {
        this.context = aContext;
        this.listData = list.getList_taches();
        layoutInflater = LayoutInflater.from(aContext);

    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Taches getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {

        convertview = layoutInflater.inflate(R.layout.lists, null);

        Taches tache = getItem(position);


        TextView titre_view = convertview.findViewById(R.id.id_titre_adapter_tache);
        TextView text_view = convertview.findViewById(R.id.id_text_view_list_taches);
        FrameLayout layout_bas = convertview.findViewById(R.id.id_layout_bas);

        if (tache.getText().toString().length() < 50) {
            ViewGroup.LayoutParams params = layout_bas.getLayoutParams();
            // Changes the height and width to the specified *pixels*
            params.height = 100;
            layout_bas.setLayoutParams(params);

        } else if (tache.getText().toString().length() < 100) {
            ViewGroup.LayoutParams params = layout_bas.getLayoutParams();
            // Changes the height and width to the specified *pixels*
            params.height = 180;
            layout_bas.setLayoutParams(params);
        } else if (tache.getText().toString().length() < 150) {
            ViewGroup.LayoutParams params = layout_bas.getLayoutParams();
            // Changes the height and width to the specified *pixels*
            params.height = 250;
            layout_bas.setLayoutParams(params);
        }



        titre_view.setText("Titre : " +tache.getNom());
        text_view.setText("Tâche à effectué : "+tache.getText());

        return convertview;
    }
}
