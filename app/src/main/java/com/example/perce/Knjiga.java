package com.example.perce;

public class Knjiga {

    public int id;
    public String naziv;
    public String autor;
    public String godina_izdanja;
    public String broj_strana;
    public int slika;
    public String opis;
    public int na_promociji;

    Knjiga(int id, String naziv, String autor, String godina_izdanja, String broj_strana, int slika, String opis, int na_promociji){
        this.id=id;
        this.naziv=naziv;
        this.autor=autor;
        this.godina_izdanja=godina_izdanja;
        this.broj_strana=broj_strana;
        this.slika=slika;
        this.opis=opis;
        this.na_promociji=na_promociji;


    }

    int getSlika(){
        return this.slika;
    }
}
