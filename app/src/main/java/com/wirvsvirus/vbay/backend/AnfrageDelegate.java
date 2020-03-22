package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;
import com.wirvsvirus.vbay.util.Tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class AnfrageDelegate {

    public void einkaufAbschliessen(EinkaufslisteDetail einkaufsliste) throws IOException {
        abbrechenEinkaufslisteBeduerftiger(einkaufsliste);
    }

    public void einkaufAbbrechen(EinkaufslisteDetail einkaufsliste) throws IOException {
        Tool.callLink("updateEinkaufslisteHelfer&email_beduerftiger="+einkaufsliste.getBeduerftiger().getEmail()+"&email_helfer="+einkaufsliste.getHelfer().get().getEmail()+"&nr_einkaufsliste="+ einkaufsliste.getNrEinkaufsliste());
        //update email löschen in einkaufsliste
    }


    public void einkaufAnnehmen(EinkaufslisteDetail einkaufsliste, Benutzer helfer) throws IOException {
        Tool.callLink("updateEinkaufslisteHelfer&email_beduerftiger="+"&email_helfer="+helfer.getEmail()+"&nr_einkaufsliste="+ einkaufsliste.getNrEinkaufsliste());
        //update helfer bei einkaufsliste
    }

    public void abbrechenEinkaufslisteBeduerftiger(EinkaufslisteDetail liste) throws IOException {
        Tool.callLink("loeschenEinkaufsliste?nr_einkaufsliste="+liste.getNrEinkaufsliste());
    }

    public void bearbeitenEinkaufsliste(EinkaufslisteDetail alt, EinkaufslisteDetail neu) throws IOException {
        abbrechenEinkaufslisteBeduerftiger(alt);
        erstellenEinkaufsliste(neu);
    }

    public void erstellenEinkaufsliste(EinkaufslisteDetail neu) throws IOException {
        Tool.callLink( "http://localhost/erstellenEinkaufsliste?nr_einkaufsliste="+neu.getNrEinkaufsliste());
    }
}
