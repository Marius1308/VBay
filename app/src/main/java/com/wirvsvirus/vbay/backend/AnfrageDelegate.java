package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;
import com.wirvsvirus.vbay.util.Tool;

import java.util.ArrayList;
import java.util.List;

class AnfrageDelegate {

    public void einkaufAbschliessen(EinkaufslisteDetail einkaufsliste) {
        //update email setzen einkaufsliste
    }

    public void einkaufAbbrechen(EinkaufslisteDetail einkaufsliste) {
        //update email löschen in einkaufsliste
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

    public void einkaufAnnehmen(EinkaufslisteDetail einkaufsliste, Benutzer helfer) {
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
