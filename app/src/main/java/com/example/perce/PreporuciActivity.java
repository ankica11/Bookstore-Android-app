package com.example.perce;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PreporuciActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preporuci);





        ArrayList<Korisnik> korisnici_za_preporuku = new ArrayList<Korisnik>();

        for(int i =0; i< KorisniciData.korisnici.size();i++){
            if(!KorisniciData.korisnici.get(i).korisnickoIme.equals(KorisniciData.ulogovanKorisnik.korisnickoIme)){
                korisnici_za_preporuku.add(KorisniciData.korisnici.get(i));
            }
        }


        PreporuciAdapter adapter = new PreporuciAdapter(PreporuciActivity.this,korisnici_za_preporuku);

        ListView lw = findViewById(R.id.lista_korisnika);
        lw.setAdapter(adapter);


        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Korisnik selectedUser = korisnici_za_preporuku.get(position);
                //provera da li je ulogovani korisnik vec preporucio knjigu izabranom korisniku

                for(int i=0; i<PreporukeData.preporuke.size(); i++){
                    if(selectedUser.korisnickoIme.equals(PreporukeData.preporuke.get(i).username) && KnjigeData.izabrana_knjiga.id==PreporukeData.preporuke.get(i).preporucenaKnjiga
                    && PreporukeData.preporuke.get(i).korisnici.contains(KorisniciData.ulogovanKorisnik.korisnickoIme)){
                        String message_failure = "Već ste preporučili knjigu korisniku @" + korisnici_za_preporuku.get(position).korisnickoIme;
                        Toast.makeText(PreporuciActivity.this, message_failure, Toast.LENGTH_LONG).show();
                        return;

                    }
                }
                 //dodaj preporuku
                int exist=0;
                for(int i=0; i<PreporukeData.preporuke.size(); i++){
                    //ako mu je neko preporucivao ovu knjigu i pre samo dodaj ulogovanog korisnika u listu korisnika koji su mu je preporucili
                    if(selectedUser.korisnickoIme.equals(PreporukeData.preporuke.get(i).username) && KnjigeData.izabrana_knjiga.id==PreporukeData.preporuke.get(i).preporucenaKnjiga){
                        PreporukeData.preporuke.get(i).korisnici.add(KorisniciData.ulogovanKorisnik.korisnickoIme);
                        exist=1;
                    }
                }

                //prvi put neko izabranom korisniku preporucuje izabranu knjigu
                if(exist==0){
                    ArrayList<String> kor = new ArrayList<String>();
                    kor.add(KorisniciData.ulogovanKorisnik.korisnickoIme);
                    PreporukeData.preporuke.add(new Preporuka(selectedUser.korisnickoIme,KnjigeData.izabrana_knjiga.id,kor));

                }

                ImageView btn = view.findViewById(R.id.btn_preporuci);
                btn.setImageResource(R.drawable.ic_baseline_check_circle_24);

                //Toast.makeText(KorisnikActivity.this, "klikno", Toast.LENGTH_SHORT).show();
                String message = "Knjiga je uspešno preporučena korisniku @" + korisnici_za_preporuku.get(position).korisnickoIme;
                Toast.makeText(PreporuciActivity.this, message, Toast.LENGTH_LONG).show();






            }
        });
    }

    public void backToDetails (View view){
        Intent intent = new Intent(this, DetaljiActivity.class);
        startActivity(intent);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){

            case R.id.pocetna:
                intent=new Intent(this, KorisnikActivity.class);
                startActivity(intent);
                return true;

            case R.id.preporuceno:
                intent=new Intent(this, PreporucenoActivity.class);
                startActivity(intent);
                return true;

            case R.id.promocije:
                intent = new Intent(this, PromocijeActivity.class);
                startActivity(intent);
                return true;

            case R.id.nalog:
                intent= new Intent(this, NalogActivity.class);
                startActivity(intent);
                return true;

            case R.id.about:
                intent= new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }
}