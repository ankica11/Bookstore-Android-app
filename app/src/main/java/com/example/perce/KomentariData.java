package com.example.perce;

import java.util.ArrayList;

public class KomentariData {

    public static ArrayList<Komentar> komentari = new ArrayList<Komentar>();


    static {
        komentari.add(new Komentar(1,"pera",1,5,"Nisam do sada čula za ovu knjigu, a zvuči mi kao nešto što oduvek želim da pročitam. :clap: Obožavam istorijske romane, ljubav i rat, a Rat i mir mi je jedna od najomiljenijih knjiga. :haugh:Lucemalo, baš ti hvala za ovu preporuku. Sigurno ću potražiti knjigu u naskorije vreme.", "11.11.2021."));
        komentari.add(new Komentar(2,"mika", 1, 4, "Nisam nesto zadovoljan da biha dao pet, ali okej je sta znam", "11.12.2021."));
        komentari.add(new Komentar(3,"pera", 2, 3, "Nisam nesto zadovoljan da biha dao pet, ali okej je sta znam", "11.2.2021."));
        komentari.add(new Komentar(4,"mika", 2, 2, "Nisam nesto zadovoljan da biha dao pet, ali okej je sta znam", "11.12.2021."));


    }
}
