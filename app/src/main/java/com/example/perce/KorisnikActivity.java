package com.example.perce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class KorisnikActivity extends AppCompatActivity {

    public KnjigeData knjigeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korisnik);

        knjigeData=new KnjigeData();
        KnjigaAdapter knjigAdapter = new KnjigaAdapter(this, knjigeData.knjige);

        ListView lw = findViewById(R.id.lista_knjiga);
        lw.setAdapter(knjigAdapter);


        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(KorisnikActivity.this, "klikno", Toast.LENGTH_SHORT).show();
                KnjigeData.izabrana_knjiga=knjigeData.knjige.get(position);
                Intent intent = new Intent(KorisnikActivity.this, DetaljiActivity.class);
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
                recreate();
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
                intent = new Intent(this, NalogActivity.class);
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