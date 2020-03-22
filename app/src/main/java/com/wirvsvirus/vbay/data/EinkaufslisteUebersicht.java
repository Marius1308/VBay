package com.wirvsvirus.vbay.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

public class EinkaufslisteUebersicht implements Serializable{

    private String emailBeduerftiger;
    private String nameBeduerftiger;
    private String vornameBeduerftiger;
    private Integer nrEinkaufsliste;

    private LocalDateTime uhrVon;
    private LocalDateTime uhrBis;
    private double entfernung;

    private Optional<String> nameHelfer;
    private Optional<String> vorHelfer;

    public String getEmailBeduerftiger() {
        return emailBeduerftiger;
    }

    public void setEmailBeduerftiger(String emailBeduerftiger) {
        this.emailBeduerftiger = emailBeduerftiger;
    }

    public Integer getNrEinkaufsliste() {
        return nrEinkaufsliste;
    }

    public void setNrEinkaufsliste(Integer nrEinkaufsliste) {
        this.nrEinkaufsliste = nrEinkaufsliste;
    }

    public Optional<String> getNameHelfer() {
        return nameHelfer;
    }

    public void setNameHelfer(Optional<String> nameHelfer) {
        this.nameHelfer = nameHelfer;
    }

    public Optional<String> getVorHelfer() {
        return vorHelfer;
    }

    public void setVorHelfer(Optional<String> vorHelfer) {
        this.vorHelfer = vorHelfer;
    }

    public String getNameBeduerftiger() {
        return nameBeduerftiger;
    }

    public void setNameBeduerftiger(String nameBeduerftiger) {
        this.nameBeduerftiger = nameBeduerftiger;
    }

    public String getVornameBeduerftiger() {
        return vornameBeduerftiger;
    }

    public void setVornameBeduerftiger(String vornameBeduerftiger) {
        this.vornameBeduerftiger = vornameBeduerftiger;
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

    public double getEntfernung() {
        return entfernung;
    }

    public void setEntfernung(double entfernung) {
        this.entfernung = entfernung;
    }
}
