package com.example.perce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.Inflater;

public class KomentariActivity extends AppCompatActivity {

    public ArrayList<Komentar> komentari = new ArrayList<Komentar>();
    public ArrayList<Komentar> komentariKnjige = new ArrayList<Komentar>();
    public KomentarAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komentari);

        komentari=KomentariData.komentari;
        for(int i=0; i<komentari.size(); i++){
            if(komentari.get(i).id_knjige==KnjigeData.izabrana_knjiga.id && !komentari.get(i).komentar.equals("")){
                komentariKnjige.add(new Komentar(1,komentari.get(i).username,komentari.get(i).id_knjige,komentari.get(i).ocena,komentari.get(i).komentar,komentari.get(i).datum));
            }
        }
        if(komentariKnjige.size() != 0){
            ImageView nocomment = findViewById(R.id.nocomment);
            nocomment.setVisibility(View.INVISIBLE);
        }
         adapter = new KomentarAdapter(this,komentariKnjige);
        ListView lw = findViewById(R.id.lista_komentara);
        lw.setAdapter(adapter);
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

    public void unesiKomentar(View view){
        //first check if user already left comment for the book
        for(int i=0; i<komentariKnjige.size(); i++){
            if(komentariKnjige.get(i).id_knjige==KnjigeData.izabrana_knjiga.id && komentariKnjige.get(i).username==KorisniciData.ulogovanKorisnik.korisnickoIme){
                Toast.makeText(KomentariActivity.this,"Već ste ostavili komentar za ovu knjigu!",Toast.LENGTH_LONG).show();

                return;
            }
        }

        //if not check if he rated the book
        int rated_flag=0;

        for(int i = 0; i< KomentariData.komentari.size(); i++){
            if(KomentariData.komentari.get(i).id_knjige==KnjigeData.izabrana_knjiga.id && KomentariData.komentari.get(i).username==KorisniciData.ulogovanKorisnik.korisnickoIme){
                rated_flag=1;

                break;
            }

        }
        if(rated_flag==0){
            Toast.makeText(this,"Morate prvo da ocenite knjigu", Toast.LENGTH_LONG).show();
            return;
        }

        //if yes open dialog



        AlertDialog.Builder builder = new AlertDialog.Builder(KomentariActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_komentar, null);

        EditText komentar=dialogView.findViewById(R.id.unet_komentar);

        builder.setView(dialogView).setPositiveButton("Pošalji", (dialogInterface, i) -> {
            int ocena=0;
            Date datum = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
            String datumFormated = sdf.format(datum);
            String kom = komentar.getText().toString();
            for(int k=0; k<komentari.size(); k++){
                if(komentari.get(k).id_knjige==KnjigeData.izabrana_knjiga.id && komentari.get(k).username==KorisniciData.ulogovanKorisnik.korisnickoIme){

                    komentari.get(k).komentar=kom;
                    komentari.get(k).datum=datumFormated;
                    ocena=komentari.get(k).ocena;

                break;
                }


            }
            komentariKnjige.add(new Komentar(0, KorisniciData.ulogovanKorisnik.korisnickoIme,
                    KnjigeData.izabrana_knjiga.id, ocena, kom, datumFormated));
            adapter.notifyDataSetChanged();

           // Log.i("komentar: ", kom);
            ImageView notfound= findViewById(R.id.nocomment);
            notfound.setVisibility(View.INVISIBLE);


        }).setNegativeButton("Odustani",(dialogInterface, i) -> {});

        builder.create();
        builder.show();
    }

    public void backToDetails(View view){
        Intent intent = new Intent(this, DetaljiActivity.class);
        startActivity(intent);
    }
}