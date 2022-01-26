package com.example.perce;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PreporuciAdapter extends ArrayAdapter<Korisnik> {

    public PreporuciAdapter(Context context, ArrayList<Korisnik> korisnici){
        super(context,0,korisnici);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_preporuci,parent,false);
        }

        Korisnik korisnik = getItem(position);



        TextView username = (TextView) convertView.findViewById(R.id.user);
        TextView ime_prezime = (TextView) convertView.findViewById(R.id.ime_prezime);

        ImageView btn = (ImageView) convertView.findViewById(R.id.btn_preporuci);


         username.setText("@"+korisnik.korisnickoIme);
         ime_prezime.setText(korisnik.ime+" " + korisnik.prezime);
         int vec_preporucio=0;
        for(int i=0; i<PreporukeData.preporuke.size(); i++){
            if(korisnik.korisnickoIme.equals(PreporukeData.preporuke.get(i).username) && KnjigeData.izabrana_knjiga.id==PreporukeData.preporuke.get(i).preporucenaKnjiga
                    && PreporukeData.preporuke.get(i).korisnici.contains(KorisniciData.ulogovanKorisnik.korisnickoIme)){

                vec_preporucio=1;


            }
        }
        if(vec_preporucio==1){
            btn.setImageResource(R.drawable.ic_baseline_check_circle_24);
        }else{
            btn.setImageResource(R.drawable.ic_baseline_person_add_alt_1_24);
        }



        return convertView;
    }
}
