package com.example.perce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class PreporucenoActivity extends AppCompatActivity {

    ArrayList<Preporuka> preporuke_korisnik = new ArrayList<Preporuka>();
    KnjigeData kdata=new KnjigeData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preporuceno);


        for(int i=0; i<PreporukeData.preporuke.size(); i++){
            if(PreporukeData.preporuke.get(i).username==KorisniciData.ulogovanKorisnik.korisnickoIme){
                preporuke_korisnik.add(new Preporuka(PreporukeData.preporuke.get(i).username, PreporukeData.preporuke.get(i).preporucenaKnjiga,
                        PreporukeData.preporuke.get(i).korisnici));
                   }
        }
        if(preporuke_korisnik.size() != 0){
            ImageView nocomment = findViewById(R.id.nocomment);
            nocomment.setVisibility(View.INVISIBLE);
        }
        PreporukaAdapter adapter = new PreporukaAdapter(this,preporuke_korisnik);
        ListView lw = findViewById(R.id.lista_preporuka);
        lw.setAdapter(adapter);

        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(KorisnikActivity.this, "klikno", Toast.LENGTH_SHORT).show();
                Preporuka preporuka = preporuke_korisnik.get(position);

                for(int i=0; i<kdata.knjige.size(); i++){
                    if(kdata.knjige.get(i).id==preporuka.preporucenaKnjiga){
                        KnjigeData.izabrana_knjiga=kdata.knjige.get(i);
                        //Log.i("knjiga", KnjigeData.izabrana_knjiga.naziv);
                        break;
                    }
                }
                Intent intent = new Intent(PreporucenoActivity.this, DetaljiActivity.class);
                startActivity(intent);

            }
        });


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
               recreate();
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