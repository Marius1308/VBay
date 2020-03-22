package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.Einkaufsliste;

import java.util.List;

class AnfrageDelegate {

    public void einkaufAbschliessen(Einkaufsliste einkaufsliste) {
        //skript einkaufsliste löschen
    }

    public void einkaufAbbrechen(Einkaufsliste einkaufsliste) {
        //neu zugeteilt+ update email = null
    }

    public List<Einkaufsliste> lesenEinkaufslistenUebersicht() {
        return null;
    }

    public void einkaufAnnehmen(Einkaufsliste einkaufsliste, Benutzer helfer) {
        //update email zu teilen
    }

    public void abbrechenEinkaufslisteBeduerftiger(Einkaufsliste liste) {
    }

    public void bearbeitenEinkaufsliste(Einkaufsliste neu) {
    }

    public void erstellenEinkaufsliste(Einkaufsliste neu) {
    }
}
