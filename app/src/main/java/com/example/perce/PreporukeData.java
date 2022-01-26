package com.example.perce;

import java.util.ArrayList;

public class PreporukeData {

    public static ArrayList<Preporuka> preporuke = new ArrayList<Preporuka>();

    static{
        ArrayList<String> kor1 = new ArrayList<String>();
        kor1.add("mika");
        kor1.add("korisnik1");
        kor1.add("korisnik2");
        preporuke.add(new Preporuka("pera", 1, kor1 ));
        ArrayList<String> kor2 = new ArrayList<String>();
        kor2.add("mika");
        kor2.add("korisnik2");
        kor2.add("korisnik3");
        preporuke.add(new Preporuka("pera", 2, kor2));
        ArrayList<String> kor3 = new ArrayList<String>();
        kor3.add("pera");
        kor3.add("korisnik1");
        kor3.add("korisnik2");
        preporuke.add(new Preporuka("mika",1, kor3));
        ArrayList<String> kor4 = new ArrayList<String>();
        kor4.add("pera");
        kor4.add("korisnik2");
        kor4.add("korisnik3");
        preporuke.add(new Preporuka("mika",2,kor4));

    }
}
