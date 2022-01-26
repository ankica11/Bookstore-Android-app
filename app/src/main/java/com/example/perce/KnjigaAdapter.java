package com.example.perce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class KnjigaAdapter extends ArrayAdapter<Knjiga> {

    public KnjigaAdapter(Context context, ArrayList<Knjiga> knjige){
        super(context,0,knjige);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_knjiga,parent,false);
        }



        Knjiga knjiga = getItem(position);

        ImageView slika = (ImageView) convertView.findViewById(R.id.slika);
        TextView naslov = (TextView)  convertView.findViewById(R.id.naslov);
        TextView autor =  (TextView)  convertView.findViewById(R.id.autor);
        ImageView promocija = (ImageView) convertView.findViewById(R.id.promocija_home);


        if(knjiga.na_promociji==0){
            promocija.setVisibility(View.INVISIBLE);
        }else{
            promocija.setVisibility(View.VISIBLE);
        }


        naslov.setText(knjiga.naziv);
        autor.setText(knjiga.autor);
        slika.setImageResource(knjiga.slika);
        return convertView;

    }


}
