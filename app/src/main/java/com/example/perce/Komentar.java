package com.example.perce;

public class Komentar {

    public int id;
    public String username;
    public int id_knjige;
    public int ocena;
    public String komentar;
    public String datum;

    public Komentar(int id, String username, int id_knjige, int ocena, String komentar, String datum) {
        this.id = id;
        this.username = username;
        this.id_knjige = id_knjige;
        this.ocena = ocena;
        this.komentar = komentar;
        this.datum = datum;
    }
}
