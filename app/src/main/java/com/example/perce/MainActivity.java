package com.example.perce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Korisnik> kd=new ArrayList<Korisnik>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kd=KorisniciData.korisnici;

    }

    public void prijava(View view) {

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        for(int i=0; i<kd.size(); i++){
            if(kd.get(i).korisnickoIme.equals(username.getText().toString()) && kd.get(i).lozinka.equals(password.getText()
                    .toString())){
                KorisniciData.ulogovanKorisnik=kd.get(i);
                break;
            }
        }

        if (KorisniciData.ulogovanKorisnik!=null){
            //navigate to korisnik pocetna
            Intent intent = new Intent(this, KorisnikActivity.class);
            startActivity(intent);

        }else{

            Toast.makeText(this, "Pogrešni kredencijali!", Toast.LENGTH_SHORT).show();
        }


    }
}