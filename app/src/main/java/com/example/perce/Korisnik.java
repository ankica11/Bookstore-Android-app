package com.example.perce;

public class Korisnik {

    public String korisnickoIme;
    public String lozinka;
    public String ime;
    public String prezime;
    public String kontakt;
    public String adresa;

    Korisnik(){}

    public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, String kontakt, String adresa) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontakt = kontakt;
        this.adresa = adresa;
    }
}
