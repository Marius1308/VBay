package com.wirvsvirus.vbay.data;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Einkaufsliste implements Serializable {

    private Benutzer beduerftiger;
    private int nrEinkaufsliste;
    private LocalDateTime uhrVon;
    private Eintrag[] eintraege;

    public Einkaufsliste(Benutzer beduerftiger, int nrEinkaufsliste, LocalDateTime uhrVon, Eintrag[] eintraege, LocalDateTime uhrBis) {
        this.beduerftiger = beduerftiger;
        this.nrEinkaufsliste = nrEinkaufsliste;
        this.uhrVon = uhrVon;
        this.eintraege = eintraege;
        this.uhrBis = uhrBis;
    }

    public int getNrEinkaufsliste() {
        return nrEinkaufsliste;
    }

    public void setNrEinkaufsliste(int nrEinkaufsliste) {
        this.nrEinkaufsliste = nrEinkaufsliste;
    }

    public LocalDateTime getUhrVon() {
        return uhrVon;
    }

    public void setUhrVon(LocalDateTime uhrVon) {
        this.uhrVon = uhrVon;
    }

    public LocalDateTime getUhrBis() {
        return uhrBis;
    }

    public void setUhrBis(LocalDateTime uhrBis) {
        this.uhrBis = uhrBis;
    }

    private LocalDateTime uhrBis;

    public Benutzer getBeduerftiger() {
        return beduerftiger;
    }

    public void setBeduerftiger(Benutzer beduerftiger) {
        this.beduerftiger = beduerftiger;
    }
}
