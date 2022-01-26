package com.example.perce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetaljiActivity extends AppCompatActivity {

    public Knjiga izabrana_knjiga=KnjigeData.izabrana_knjiga;

    public ArrayList<Komentar> komentariZaKnjigu = new ArrayList<Komentar>();
    public int korisnik_ocena=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji);

        //Toast.makeText(DetaljiActivity.this,"Izabrana knjiga:" + izabrana_knjiga.naziv, Toast.LENGTH_SHORT).show();

        for(int i=0; i<KomentariData.komentari.size(); i++){
            if(KomentariData.komentari.get(i).id_knjige == izabrana_knjiga.id && !KomentariData.komentari.get(i).komentar.equals("")){
                komentariZaKnjigu.add(new Komentar(KomentariData.komentari.get(i).id,KomentariData.komentari.get(i).username,KomentariData.komentari.get(i).id_knjige,KomentariData.komentari.get(i).ocena,
                        KomentariData.komentari.get(i).komentar, KomentariData.komentari.get(i).datum));
            }
            if(KomentariData.komentari.get(i).id_knjige==izabrana_knjiga.id && KomentariData.komentari.get(i).username==KorisniciData.ulogovanKorisnik.korisnickoIme){
                korisnik_ocena=KomentariData.komentari.get(i).ocena;
            }
        }
        String topKomentar="Nema komentara za ovu knjigu";
        String topKorisnik="@nobody";
        String topDatum="xx.xx.xxxx.";
        String topImePrezime="No name";
        int topOcena=0;
        Korisnik topKor = null;





        ImageView ocena1 = findViewById(R.id.ocena1top);
        ImageView ocena2 = findViewById(R.id.ocena2top);
        ImageView ocena3 = findViewById(R.id.ocena3top);
        ImageView ocena4 = findViewById(R.id.ocena4top);
        ImageView ocena5 = findViewById(R.id.ocena5top);

        if(komentariZaKnjigu.size()!= 0){

            topKomentar=komentariZaKnjigu.get(0).komentar;
            topKorisnik=komentariZaKnjigu.get(0).username;
            topDatum=komentariZaKnjigu.get(0).datum;
            topOcena=komentariZaKnjigu.get(0).ocena;

            for(int i=0; i<KorisniciData.korisnici.size(); i++){
                if(KorisniciData.korisnici.get(i).korisnickoIme.equals(komentariZaKnjigu.get(0).username)){
                    topKor=KorisniciData.korisnici.get(i);
                    topImePrezime=topKor.ime+" "+topKor.prezime;
                    break;
                }
            }


            switch(topOcena){

                case 1:
                    ocena1.setImageResource(R.drawable.ic_baseline_star_24);
                    ocena2.setVisibility(View.INVISIBLE);
                    ocena3.setVisibility(View.INVISIBLE);
                    ocena4.setVisibility(View.INVISIBLE);
                    ocena5.setVisibility(View.INVISIBLE);


                    break;
                case 2:
                    ocena1.setImageResource(R.drawable.ic_baseline_star_24);
                    ocena2.setImageResource(R.drawable.ic_baseline_star_24);
                    ocena3.setVisibility(View.INVISIBLE);
                    ocena4.setVisibility(View.INVISIBLE);
                    ocena5.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    ocena1.setImageResource(R.drawable.ic_baseline_star_24);
                    ocena2.setImageResource(R.drawable.ic_baseline_star_24);
                    ocena3.setImageResource(R.drawable.ic_baseline_star_24);
                    ocena4.setVisibility(View.INVISIBLE);
                    ocena5.setVisibility(View.INVISIBLE);
                case 4:
                    ocena1.setImageResource(R.drawable.ic_baseline_star_24);
                    ocena2.setImageResource(R.drawable.ic_baseline_star_24);
                    ocena3.setImageResource(R.drawable.ic_baseline_star_24);
                    ocena4.setImageResource(R.drawable.ic_baseline_star_24);
                    ocena5.setImageResource(R.drawable.ic_baseline_star_24);
                    ocena5.setVisibility(View.INVISIBLE);
                default:
                    break;


            }

        }else{
            topKomentar="Nema komentara za ovu knjigu";
            topKorisnik="nobody";
            topDatum="xx.xx.xxxx.";
            topImePrezime="No name";
            ocena1.setVisibility(View.INVISIBLE);
            ocena2.setVisibility(View.INVISIBLE);
            ocena3.setVisibility(View.INVISIBLE);
            ocena4.setVisibility(View.INVISIBLE);
            ocena5.setVisibility(View.INVISIBLE);

        }

        TextView ocena=findViewById(R.id.ocena);
        ImageView zvezda=findViewById(R.id.full_star);

        if(korisnik_ocena != 0){
            ocena.setText(korisnik_ocena + "/5");

            zvezda.setImageResource(R.drawable.ic_blue_star);
        }



        TextView naslov= findViewById(R.id.naslov);
        TextView autor=findViewById(R.id.autor);
        ImageView slika=findViewById(R.id.slika);
        TextView godina_izdanja=findViewById(R.id.godina);
        TextView broj_strana=findViewById(R.id.strane);
        //TextView opis=findViewById(R.id.opis);
        TextView usernameTop = findViewById(R.id.username_top);
        TextView datumTop = findViewById(R.id.datum_top);
        TextView komentarTop= findViewById(R.id.komentar_top);
        TextView brojKomentara=findViewById(R.id.br_kom);
        TextView ime_prezime_top = findViewById(R.id.ime_prezime_top);

        naslov.setText(izabrana_knjiga.naziv);
        autor.setText(izabrana_knjiga.autor);
        slika.setImageResource(izabrana_knjiga.slika);
        godina_izdanja.setText("Godina izdanja: " + izabrana_knjiga.godina_izdanja);
        broj_strana.setText("Broj strana: " + izabrana_knjiga.broj_strana);
        //opis.setText(izabrana_knjiga.opis);
        usernameTop.setText("@"+topKorisnik);
        datumTop.setText(topDatum);
        komentarTop.setText(topKomentar);
        brojKomentara.setText(komentariZaKnjigu.size()+"");
        ime_prezime_top.setText(topImePrezime);
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

    public void prikaziOpis(View view){
        Intent intent = new Intent(DetaljiActivity.this,OpisActivity.class);
        startActivity(intent);
    }

    public void backToHome (View view){
        Intent intent = new Intent(this, KorisnikActivity.class);
        startActivity(intent);
    }

    public void oceni(View view){

        if(korisnik_ocena == 0){

            //open custom dialog with staaaars for rating

            AlertDialog.Builder builder = new AlertDialog.Builder(DetaljiActivity.this);

            //inflater pravi od naseg layout-a view
            LayoutInflater inflater = this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.dialog,null);

            RatingBar ratingBar = dialogView.findViewById(R.id.simpleRatingBar);

            builder.setView(dialogView).setPositiveButton("Potvrdi",(dialogInterface, i) -> {

                korisnik_ocena=(int) ratingBar.getRating();
                TextView ocena1=findViewById(R.id.ocena);
                ImageView zvezda2=findViewById(R.id.full_star);

                if(korisnik_ocena != 0){
                    ocena1.setText(korisnik_ocena + "/5");
                    zvezda2.setImageResource(R.drawable.ic_blue_star);

                    //sacuvaj u listi svih komentara
                    KomentariData.komentari.add(new Komentar(1, KorisniciData.ulogovanKorisnik.korisnickoIme, izabrana_knjiga.id, korisnik_ocena, "",""));
                    //Log.i("nova ocena",KomentariData.komentari.get(KomentariData.komentari.size()-1).id_knjige + " " + KomentariData.komentari.get(KomentariData.komentari.size()-1).username + " " + KomentariData.komentari.get(KomentariData.komentari.size()-1).ocena);
                }

            });

            builder.create();
            builder.show();







        }
    }

    public void prikaziKomentare(View view){
        //navigate to comments
        Intent intent = new Intent(DetaljiActivity.this, KomentariActivity.class);
        startActivity(intent);

    }

    public void preporuci(View view){
        Intent intent = new Intent(DetaljiActivity.this, PreporuciActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        recreate();
    }
}