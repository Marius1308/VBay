package com.wirvsvirus.vbay.backend;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;
import com.wirvsvirus.vbay.util.DBConnector;
import com.wirvsvirus.vbay.util.Tool;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UebersichtDelegate {

    public List<EinkaufslisteUebersicht> lesenEinkaufslistenHelferUebersicht(Benutzer helfer) throws IOException, ExecutionException, InterruptedException {
        List<String> out = new DBConnector().execute( "select.php?query=lesenEinkaufslistenHelferUebersicht?email_helfer="+Tool.decodeURL(helfer.getEmail())).get();
        List<EinkaufslisteUebersicht> einkaufslisten= new ArrayList<>();

        for (String line:out){
            String[] outo = line.split(";");
            einkaufslisten.add(Tool.createEinkaufslisteUebersicht(outo));
        }
        return einkaufslisten;
    }

    public List<EinkaufslisteUebersicht> lesenEinkaufslistenBeduerftigerUebersicht(Benutzer beduerftiger) throws IOException, ExecutionException, InterruptedException {
        List<String> out = new DBConnector().execute( "select.php?query=lesenEinkaufslistenBeduerftigerUebersicht?email="+Tool.decodeURL(beduerftiger.getEmail())).get();
        List<EinkaufslisteUebersicht> einkaufslisten= new ArrayList<>();

        for (String line:out){
            String[] outo = line.split(";");
            einkaufslisten.add(Tool.createEinkaufslisteUebersicht(outo));
        }
        return einkaufslisten;
    }

    public List<EinkaufslisteUebersicht> lesenEinkaufslistenUebersicht(Benutzer helfer) throws IOException, ExecutionException, InterruptedException {
        List<String> out = new DBConnector().execute( "select.php?query=lesenEinkaufslistenUebersicht&email="+Tool.encodeURL(helfer.getEmail())).get();
        List<EinkaufslisteUebersicht> einkaufslisten= new ArrayList<>();

        for (String line:out){
            String[] outo = line.split(";");
            einkaufslisten.add(Tool.createEinkaufslisteUebersicht(outo));
        }
        return einkaufslisten;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public EinkaufslisteDetail lesenDetail(EinkaufslisteUebersicht liste) throws IOException {
        List<String> out = Tool.callLink( "http://localhost/lesenDetail&nr_einkaufsliste="+Tool.encodeURL(liste.getNrEinkaufsliste()+"&emailBeduerftiger="+Tool.encodeURL(liste.getEmailBeduerftiger())));
        Tool.createEinkaufslisteDetail((String[])out.toArray());
        return Tool.createEinkaufslisteDetail((String[])out.toArray());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<EinkaufslisteDetail> lesenDetailUebersicht(Benutzer helfer) throws IOException {
        List<String> out = Tool.callLink( "http://localhost/lesenDetail&email="+Tool.encodeURL(helfer.getEmail()));
        List<EinkaufslisteDetail> einkaufslisten= new ArrayList<>();

        for (String line:out){
            String[] outo = line.split(";");
            einkaufslisten.add(Tool.createEinkaufslisteDetail(outo));
        }
        return einkaufslisten;
    }
}