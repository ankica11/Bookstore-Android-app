package com.example.perce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PromocijeActivity extends AppCompatActivity {

    public KnjigeData podaci;
    public ArrayList<Knjiga> knjige_promocija = new ArrayList<Knjiga>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promocije);

        podaci=new KnjigeData();

        for(int i=0; i<podaci.knjige.size(); i++){
            if(podaci.knjige.get(i).na_promociji==1){
                knjige_promocija.add(podaci.knjige.get(i));
            }
        }
        PromocijaAdapter adapter = new PromocijaAdapter(this, knjige_promocija);

        ListView lw = findViewById(R.id.lista_promocija);
        lw.setAdapter(adapter);


        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(KorisnikActivity.this, "klikno", Toast.LENGTH_SHORT).show();
                KnjigeData.izabrana_knjiga=knjige_promocija.get(position);
                Intent intent = new Intent(PromocijeActivity.this, DetaljiActivity.class);
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
                intent=new Intent(this, PreporucenoActivity.class);
                startActivity(intent);
                return true;

            case R.id.promocije:
                recreate();
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