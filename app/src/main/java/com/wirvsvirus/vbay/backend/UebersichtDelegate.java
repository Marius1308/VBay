package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.Einkaufsliste;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UebersichtDelegate {

    public List<EinkaufslisteUebersicht> lesenEinkaufslistenHelferUebersicht(Benutzer helfer) {
        String out = Tool.execPHPString( "http://localhost//lesenEinkaufslistenHelferUebersicht?email_helfer="+Tool.decodeURL(helfer.getEmail()));
        List<EinkaufslisteUebersicht> einkaufslisten= new ArrayList<>();

        String[] outLines = out.split("\\r?\\n");
        for (int i =0;i<outLines.length;i++){
            String[] outo = outLines[i].split(";");
            einkaufslisten.add(Tool.createEinkaufsliste(outo));
        }
        return einkaufslisten;
    }

    public List<EinkaufslisteUebersicht> lesenEinkaufslistenBeduerftigerUebersicht(Benutzer beduerftiger) {
        String out = Tool.execPHPString( "http://localhost/lesenEinkaufslistenBeduerftigerUebersicht?email="+Tool.decodeURL(beduerftiger.getEmail()));
        List<EinkaufslisteUebersicht> einkaufslisten= new ArrayList<>();

        String[] outLines = out.split("\\r?\\n");
        for (int i =0;i<outLines.length;i++){
            String[] outo = outLines[i].split(";");
            einkaufslisten.add(Tool.createEinkaufsliste(outo));
        }
        return einkaufslisten;
    }
}