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
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LicneInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licne_info);

        EditText ime = findViewById(R.id.ime_info);
        EditText prezime = findViewById(R.id.prezime_info);
        EditText adresa = findViewById(R.id.adresa_info);
        EditText telefon = findViewById(R.id.telefon_info);
        TextView username = findViewById(R.id.username_info);

        ime.setText(KorisniciData.ulogovanKorisnik.ime);
        prezime.setText(KorisniciData.ulogovanKorisnik.prezime);
        adresa.setText(KorisniciData.ulogovanKorisnik.adresa);
        telefon.setText(KorisniciData.ulogovanKorisnik.kontakt);
        username.setText("@"+KorisniciData.ulogovanKorisnik.korisnickoIme);
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

    public void promeni(View view){

        EditText ime = findViewById(R.id.ime_info);
        EditText prezime = findViewById(R.id.prezime_info);
        EditText adresa = findViewById(R.id.adresa_info);
        EditText telefon = findViewById(R.id.telefon_info);

        KorisniciData.ulogovanKorisnik.ime=ime.getText().toString();
        KorisniciData.ulogovanKorisnik.prezime=prezime.getText().toString();
        KorisniciData.ulogovanKorisnik.adresa=adresa.getText().toString();
        KorisniciData.ulogovanKorisnik.kontakt=telefon.getText().toString();

        for(int i=0; i<KorisniciData.korisnici.size(); i++){
            if(KorisniciData.korisnici.get(i).korisnickoIme.equals(KorisniciData.ulogovanKorisnik.korisnickoIme)){
                KorisniciData.korisnici.get(i).ime=ime.getText().toString();
                KorisniciData.korisnici.get(i).prezime=prezime.getText().toString();
                KorisniciData.korisnici.get(i).adresa=adresa.getText().toString();
                KorisniciData.korisnici.get(i).kontakt=telefon.getText().toString();
                Toast.makeText(this, "Uspešno promenjene lične informacije", Toast.LENGTH_LONG).show();
                break;
            }
        }


    }
}