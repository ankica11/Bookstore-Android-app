package com.example.perce;

import java.util.ArrayList;

public class Preporuka {

    public String username;
    public int preporucenaKnjiga;
    public ArrayList<String> korisnici;

    public Preporuka(String username, int preporucenaKnjiga, ArrayList<String> korisnici) {
        this.username = username;
        this.preporucenaKnjiga = preporucenaKnjiga;
        this.korisnici = korisnici;
    }

    Preporuka(){



    }
}
