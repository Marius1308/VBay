package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;
import com.wirvsvirus.vbay.util.Tool;

import java.util.ArrayList;
import java.util.List;

class AnfrageDelegate {

    public void einkaufAbschliessen(EinkaufslisteDetail einkaufsliste) {
        abbrechenEinkaufslisteBeduerftiger(einkaufsliste);
    }

    public void einkaufAbbrechen(EinkaufslisteDetail einkaufsliste) {
        Tool.execPHPString( "http://localhost/updateEinkaufslisteHelfer&email_beduerftiger="+einkaufsliste.getBeduerftiger().getEmail()+"&email_helfer="+einkaufsliste.getHelfer().get().getEmail()+"&nr_einkaufsliste="+ einkaufsliste.getNrEinkaufsliste());
        //update email löschen in einkaufsliste
    }


    public void einkaufAnnehmen(EinkaufslisteDetail einkaufsliste, Benutzer helfer) {
        Tool.execPHPString( "http://localhost/updateEinkaufslisteHelfer&email_beduerftiger="+"&email_helfer="+helfer.getEmail()+"&nr_einkaufsliste="+ einkaufsliste.getNrEinkaufsliste());
        //update helfer bei einkaufsliste
    }

    public void abbrechenEinkaufslisteBeduerftiger(EinkaufslisteDetail liste) {
        String out = Tool.execPHPString( "http://localhost/loeschenEinkaufsliste?nr_einkaufsliste="+liste.getNrEinkaufsliste());
    }

    public void bearbeitenEinkaufsliste(EinkaufslisteDetail alt, EinkaufslisteDetail neu) {
    abbrechenEinkaufslisteBeduerftiger(alt);
    erstellenEinkaufsliste(neu);
    }

    public void erstellenEinkaufsliste(EinkaufslisteDetail neu) {
        String out = Tool.execPHPString( "http://localhost/erstellenEinkaufsliste?nr_einkaufsliste="+neu.getNrEinkaufsliste());
    }
}
