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

public class PromenaLozinkeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promena_lozinke);

        TextView username = findViewById(R.id.username_pass);
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

    public void promeniLozinku (View view){

        EditText nova_lozinka = findViewById(R.id.nova_lozinka);
        EditText potvrda_lozinke = findViewById(R.id.potvrda_lozinke);

        if(nova_lozinka.getText().toString().equals(potvrda_lozinke.getText().toString())){
            //uspeh
            KorisniciData.ulogovanKorisnik.lozinka=nova_lozinka.getText().toString();

            for(int i=0; i<KorisniciData.korisnici.size(); i++){
                if(KorisniciData.korisnici.get(i).korisnickoIme.equals(KorisniciData.ulogovanKorisnik.korisnickoIme)){
                    KorisniciData.korisnici.get(i).lozinka=nova_lozinka.getText().toString();

                    break;
                }
            }
            Toast.makeText(this, "Lozinka je uspešno promenjena",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Lozinka i potvrda lozinke se razlikuju", Toast.LENGTH_LONG).show();
        }
    }
}