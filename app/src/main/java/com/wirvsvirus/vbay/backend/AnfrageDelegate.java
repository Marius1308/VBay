package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.Einkaufsliste;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;

import java.util.ArrayList;
import java.util.List;

class AnfrageDelegate {

    public void einkaufAbschliessen(Einkaufsliste einkaufsliste) {
        //update email setzen einkaufsliste
    }

    public void einkaufAbbrechen(Einkaufsliste einkaufsliste) {
        //update email löschen in einkaufsliste
    public void einkaufAbbrechen(EinkaufslisteDetail einkaufsliste) {
        /*
        UPDATE EINKAUFSLISTE SET EMAIL_HELFER = (NULL)
        WHERE EMAIL = ? AND NR_EINKAUFSLISTE = ?
         */
    }

    public List<EinkaufslisteUebersicht> lesenEinkaufslistenUebersicht() {
        String out = Tool.execPHPString( "http://localhost/lesenEinkaufslistenUebersicht");
        List<EinkaufslisteUebersicht> einkaufslisten= new ArrayList<>();

        String[] outLines = out.split("\\r?\\n");
        for (int i =0;i<outLines.length;i++){
            String[] outo = outLines[i].split(";");
            einkaufslisten.add(Tool.createEinkaufsliste(outo));
        }
        return einkaufslisten;
    }

    public void einkaufAnnehmen(Einkaufsliste einkaufsliste, Benutzer helfer) {
        //update helfer bei einkaufsliste
    }

    public void abbrechenEinkaufslisteBeduerftiger(Einkaufsliste liste) {
        String out = Tool.execPHPString( "http://localhost/loeschenEinkaufsliste?nr_einkaufsliste="+liste.getNrEinkaufsliste());
    }

    public void bearbeitenEinkaufsliste(Einkaufsliste alt, Einkaufsliste neu) {
    abbrechenEinkaufslisteBeduerftiger(alt);
    erstellenEinkaufsliste(neu);
    }

    public void erstellenEinkaufsliste(Einkaufsliste neu) {
        String out = Tool.execPHPString( "http://localhost/erstellenEinkaufsliste?nr_einkaufsliste="+neu.getNrEinkaufsliste());
    }
}
