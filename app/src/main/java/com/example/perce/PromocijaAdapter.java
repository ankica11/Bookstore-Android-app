package com.example.perce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PromocijaAdapter extends ArrayAdapter<Knjiga> {

    public PromocijaAdapter(Context context, ArrayList<Knjiga> promocije){
        super(context,0,promocije);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_promocija,parent,false);
        }

        Knjiga knjiga = getItem(position);






        TextView naslov = (TextView) convertView.findViewById(R.id.naslov_promocija);
        TextView autor = (TextView) convertView.findViewById(R.id.autor_promocija);
        TextView godina = (TextView) convertView.findViewById(R.id.godina_promocija);
        TextView strane = (TextView) convertView.findViewById(R.id.strane_promocija);
        ImageView slika = (ImageView) convertView.findViewById(R.id.slika_promocija);



        naslov.setText(knjiga.naziv);
        autor.setText("Autor: " + knjiga.autor);
        godina.setText("Godina izdanja: " + knjiga.godina_izdanja);
        strane.setText("Broj strana: " + knjiga.broj_strana);
        slika.setImageResource(knjiga.slika);








        return convertView;
    }
}
