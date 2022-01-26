package com.example.perce;

import java.util.ArrayList;

public class KorisniciData {

    public static ArrayList<Korisnik> korisnici;
    public static Korisnik ulogovanKorisnik;

    static {
       korisnici=new ArrayList<Korisnik>();
       ulogovanKorisnik=null;
        korisnici.add(new Korisnik("pera", "pera123", "Pera", "Perić", "060111222", "Pale Braće 23a"));
        korisnici.add(new Korisnik("mika", "mika123", "Mika", "Mikić", "06033355", "Pale Braće 40b"));
        korisnici.add(new Korisnik("korisnik1", "kor1", "Korisnik", "Korisniković", "066067416", "Neznanog Junaka 28c"));
        korisnici.add(new Korisnik("korisnik2", "kor2", "Anka", "Petrović", "060111222", "Pale Braće 24a"));
        korisnici.add(new Korisnik("korisnik3", "kor3", "Mihajlo", "Milutinović", "06033355", "Pale Braće 40b"));
        korisnici.add(new Korisnik("korisnik4", "kor4", "Milena", "Pavlović", "066067416", "Neznanog Junaka 28b"));
        korisnici.add(new Korisnik("korisnik5", "kor5", "Lazar", "Kotromanić", "060111222", "Pale Brćce 25a"));
        korisnici.add(new Korisnik("korisnik6", "kor6", "Sofija", "Jovanović", "06033355", "Pale Braće 41b"));
        korisnici.add(new Korisnik("korisnik7", "kor7", "Branislav", "Lazić", "066067416", "Neznanog Junaka 29c"));

    }
}
