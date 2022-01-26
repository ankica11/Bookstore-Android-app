package com.example.perce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class OpisActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opis);



        TextView naslov=findViewById(R.id.naslov_opis);
        TextView autor=findViewById(R.id.autor_opis);
        TextView opis=findViewById(R.id.opis);

        naslov.setText(KnjigeData.izabrana_knjiga.naziv);
        autor.setText(KnjigeData.izabrana_knjiga.autor);
        opis.setText(KnjigeData.izabrana_knjiga.opis);

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

            default:
                return super.onOptionsItemSelected(item);

        }

    }
}