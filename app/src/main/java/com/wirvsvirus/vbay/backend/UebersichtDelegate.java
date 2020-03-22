package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.Einkaufsliste;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UebersichtDelegate {

    public List<Einkaufsliste> lesenEinkaufslistenHelferUebersicht(Benutzer helfer) {
        String out = Tool.execPHPString( "http://localhost//lesenEinkaufslistenHelferUebersicht?email_helfer="+Tool.decodeURL(helfer.getEmail()));
        List<Einkaufsliste> einkaufslisten= new ArrayList<Einkaufsliste>();

        String[] outLines = out.split("\\r?\\n");
                for (int i =0;i<outLines.length;i++){
                    String[] outo = outLines[i].split(";");
                    einkaufslisten.add(Tool.createEinkaufsliste(outo));
                }
        return einkaufslisten;
    }

    public List<Einkaufsliste> lesenEinkaufslistenBeduerftigerUebersicht(Benutzer beduerftiger) {
        String out = Tool.execPHPString( "http://localhost/lesenEinkaufslistenBeduerftigerUebersicht?email="+Tool.decodeURL(beduerftiger.getEmail()));
        List<Einkaufsliste> einkaufslisten= new ArrayList<Einkaufsliste>();

        String[] outLines = out.split("\\r?\\n");
        for (int i =0;i<outLines.length;i++){
            String[] outo = outLines[i].split(";");
            einkaufslisten.add(Tool.createEinkaufsliste(outo));
        }
        return einkaufslisten;
    }
}
