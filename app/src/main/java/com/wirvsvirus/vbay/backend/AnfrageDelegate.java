package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;
import com.wirvsvirus.vbay.util.DBConnector;
import com.wirvsvirus.vbay.util.Tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class AnfrageDelegate {

    public void einkaufAbschliessen(EinkaufslisteDetail einkaufsliste) throws IOException {
        abbrechenEinkaufslisteBeduerftiger(einkaufsliste);
    }

    public void einkaufAbbrechen(EinkaufslisteDetail einkaufsliste) throws IOException {
        new DBConnector().execute("update.php?query=updateEinkaufslisteHelfer&email_beduerftiger="+einkaufsliste.getBeduerftiger().getEmail()+"&email_helfer="+einkaufsliste.getHelfer().get().getEmail()+"&nr_einkaufsliste="+ einkaufsliste.getNrEinkaufsliste());
        //update email löschen in einkaufsliste
    }


    public void einkaufAnnehmen(EinkaufslisteDetail einkaufsliste, Benutzer helfer) throws IOException {
        new DBConnector().execute("update.php?query=updateEinkaufslisteHelfer&email_beduerftiger="+"&email_helfer="+helfer.getEmail()+"&nr_einkaufsliste="+ einkaufsliste.getNrEinkaufsliste());
        //update helfer bei einkaufsliste
    }

    public void abbrechenEinkaufslisteBeduerftiger(EinkaufslisteDetail liste) throws IOException {
        new DBConnector().execute("delete.php?query=loeschenEinkaufsliste?nr_einkaufsliste="+liste.getNrEinkaufsliste());
    }

    public void bearbeitenEinkaufsliste(EinkaufslisteDetail alt, EinkaufslisteDetail neu) throws IOException {
        abbrechenEinkaufslisteBeduerftiger(alt);
        erstellenEinkaufsliste(neu);
    }

    public void erstellenEinkaufsliste(EinkaufslisteDetail neu) throws IOException {
        new DBConnector().execute("insert.php?query=erstellenEinkaufsliste?nr_einkaufsliste="+neu.getNrEinkaufsliste());
    }
}
