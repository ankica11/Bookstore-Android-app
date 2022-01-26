package com.example.perce;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class KomentarAdapter extends ArrayAdapter<Komentar> {

    public KomentarAdapter(Context context, ArrayList<Komentar> komentari){
        super(context,0,komentari);
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_komentar,parent,false);
        }

        Komentar komentar = getItem(position);
        Korisnik korisnik=null;



        for(int i=0; i<KorisniciData.korisnici.size();i++){
            if(KorisniciData.korisnici.get(i).korisnickoIme.equals(komentar.username)){
                korisnik=KorisniciData.korisnici.get(i);
                break;
            }
        }


        TextView usernameKom = (TextView) convertView.findViewById(R.id.username_kom);
        TextView ime_prezime = (TextView) convertView.findViewById(R.id.ime_prezime_kom);

        TextView datumKom = (TextView) convertView.findViewById(R.id.datum_kom);
        TextView komentarKom = (TextView) convertView.findViewById(R.id.komentar_kom);
        TextView ocena = (TextView) convertView.findViewById(R.id.ocena);

        usernameKom.setText("@"+komentar.username);
        datumKom.setText(komentar.datum);
        komentarKom.setText(komentar.komentar);
        ocena.setText(komentar.ocena+"");
        if(korisnik!=null){
        ime_prezime.setText(korisnik.ime+" "+korisnik.prezime);}





        return convertView;
    }
}
