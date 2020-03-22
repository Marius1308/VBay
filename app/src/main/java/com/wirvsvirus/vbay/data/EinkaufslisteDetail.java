package com.wirvsvirus.vbay.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

public class EinkaufslisteDetail implements Serializable {

    private Benutzer beduerftiger;
    private int nrEinkaufsliste;
    private LocalDateTime uhrVon;
    private LocalDateTime uhrBis;
    private Eintrag[] eintraege;

    private Optional<Benutzer> helfer;

    public EinkaufslisteDetail(Benutzer beduerftiger, int nrEinkaufsliste, LocalDateTime uhrVon, Eintrag[] eintraege, LocalDateTime uhrBis) {
        this.beduerftiger = beduerftiger;
        this.nrEinkaufsliste = nrEinkaufsliste;
        this.uhrVon = uhrVon;
        this.eintraege = eintraege;
        this.uhrBis = uhrBis;
    }

    public EinkaufslisteDetail(){
        super();
    }

    public Eintrag[] getEintraege() {
        return eintraege;
    }

    public void setEintraege(Eintrag[] eintraege){
        this.eintraege=eintraege;
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

    public Benutzer getBeduerftiger() {
        return beduerftiger;
    }

    public void setBeduerftiger(Benutzer beduerftiger) {
        this.beduerftiger = beduerftiger;
    }

    public Optional<Benutzer> getHelfer(){
        return helfer;

    }
    public void setHelfer(Optional<Benutzer> helfer){
    this.helfer=helfer;
    }
}
