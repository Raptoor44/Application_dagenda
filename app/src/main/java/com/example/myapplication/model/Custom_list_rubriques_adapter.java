package com.example.myapplication.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class Custom_list_rubriques_adapter extends BaseAdapter {


    private List<List_rubriques> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public Custom_list_rubriques_adapter(Context aContext, List<List_rubriques> list) {
        this.context = aContext;
        this.listData = list;
        layoutInflater = LayoutInflater.from(aContext);

    }


    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public List_rubriques getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {

        convertview = layoutInflater.inflate(R.layout.rbriques, null);

        List_rubriques rubriques = getItem(position);

        TextView titre = convertview.findViewById(R.id.id_rubrique_titre_de_la_rubrique);


        titre.setText(rubriques.getNom());

        return convertview;
    }
}
