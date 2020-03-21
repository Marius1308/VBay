package com.wirvsvirus.vbay.data;

import java.io.Serializable;

public class Benutzer implements Serializable {
    private String email;
    private String name;
    private String vorname;
    private Integer plz;
    private String ort;
    private String strasseHausnr;
    private String adresszusatz;
    private String telefonNr;
    private String passwort;

    public Benutzer(String email, String name, String vorname, Integer plz, String ort, String strasseHausnr, String adresszusatz, String telefonNr, String passwort) {
        this.email = email;
        this.name = name;
        this.vorname = vorname;
        this.plz = plz;
        this.ort = ort;
        this.strasseHausnr = strasseHausnr;
        this.adresszusatz = adresszusatz;
        this.telefonNr = telefonNr;
        this.passwort = passwort;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getStrasseHausnr() {
        return strasseHausnr;
    }

    public void setStrasseHausnr(String strasseHausnr) {
        this.strasseHausnr = strasseHausnr;
    }

    public String getAdresszusatz() {
        return adresszusatz;
    }

    public void setAdresszusatz(String adresszusatz) {
        this.adresszusatz = adresszusatz;
    }

    public String getTelefonNr() {
        return telefonNr;
    }

    public void setTelefonNr(String telefonNr) {
        this.telefonNr = telefonNr;
    }

    public String getPasswort(){
        return passwort;
    }
}
