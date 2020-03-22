package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;
import com.wirvsvirus.vbay.util.Tool;

import java.io.IOException;
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

    public List<EinkaufslisteUebersicht> lesenEinkaufslistenUebersicht(Benutzer helfer) {
        String out = Tool.execPHPString( "http://localhost/lesenEinkaufslistenUebersicht&email="+Tool.encodeURL(helfer.getEmail()));
        List<EinkaufslisteUebersicht> einkaufslisten= new ArrayList<>();

        String[] outLines = out.split("\\r?\\n");
        for (int i =0;i<outLines.length;i++){
            String[] outo = outLines[i].split(";");
            einkaufslisten.add(Tool.createEinkaufsliste(outo));
        }
        return einkaufslisten;
    }

    public EinkaufslisteDetail lesenDetail(EinkaufslisteUebersicht liste) {
        return null;
    }

    public List<EinkaufslisteDetail> lesenDetailUebersicht(Benutzer helfer) {
        return null;
    }
}