package com.example.perce;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PreporukaAdapter extends ArrayAdapter<Preporuka> {

    public PreporukaAdapter(Context context, ArrayList<Preporuka> preporuke){
        super(context,0,preporuke);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_preporuka,parent,false);
        }

        Preporuka preporuka = getItem(position);
        Knjiga knjiga=null;
        KnjigeData kd = new KnjigeData();
        ArrayList<Knjiga> knjige = kd.knjige;
        for (int i =0 ;i<knjige.size(); i++){
            if(knjige.get(i).id==preporuka.preporucenaKnjiga){
                knjiga = new Knjiga(knjige.get(i).id,knjige.get(i).naziv,knjige.get(i).autor,knjige.get(i).godina_izdanja,
                        knjige.get(i).broj_strana, knjige.get(i).slika, knjige.get(i).opis, knjige.get(i).na_promociji);
                break;
            }

        }



        TextView naslov = (TextView) convertView.findViewById(R.id.naslov_preporuka);
        TextView autor = (TextView) convertView.findViewById(R.id.autor_preporuka);
        TextView godina = (TextView) convertView.findViewById(R.id.godina_preporuka);
        TextView strane = (TextView) convertView.findViewById(R.id.strane_preporuka);
        ImageView slika = (ImageView) convertView.findViewById(R.id.slika_preporuka);
        TextView korisnici = (TextView) convertView.findViewById(R.id.korisnici_preporuka);
        TextView na_promociji = (TextView) convertView.findViewById(R.id.na_promociji);
        ImageView na_promociji_icon = (ImageView) convertView.findViewById(R.id.icon_na_promociji);

        naslov.setText(knjiga.naziv);
        autor.setText("Autor: " + knjiga.autor);
        godina.setText("Godina izdanja: " + knjiga.godina_izdanja);
        strane.setText("Broj strana: " + knjiga.broj_strana);
        slika.setImageResource(knjiga.slika);
        if(knjiga.na_promociji==0){
            na_promociji.setText("");
            na_promociji_icon.setVisibility(View.INVISIBLE);

        }else{
            na_promociji.setText("Na promociji!");
            na_promociji_icon.setVisibility(View.VISIBLE);
        }
        String peoples_recommendations = "";
        if(preporuka.korisnici.size()==1){
            peoples_recommendations=preporuka.korisnici.get(0) + " vam preporučuje ovo";
        }
        if(preporuka.korisnici.size()==2){
            peoples_recommendations=preporuka.korisnici.get(0) + ", " + preporuka.korisnici.get(1) + " vam preporučuju ovo";
        }
        if(preporuka.korisnici.size()>2){
            int br = preporuka.korisnici.size()-2;
            if(br>1){
            peoples_recommendations=preporuka.korisnici.get(0) + ", " + preporuka.korisnici.get(1) + " i još "
                    + br + " korisnika vam preporučuju ovo";}
            else{
                peoples_recommendations=preporuka.korisnici.get(0) + ", " + preporuka.korisnici.get(1) + " i još "
                        + br + " korisnik vam preporučuju ovo";
            }
        }
        korisnici.setText(peoples_recommendations);







        return convertView;
    }
}
