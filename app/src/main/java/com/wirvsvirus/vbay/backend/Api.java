package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.Einkaufsliste;
import com.wirvsvirus.vbay.data.Eintrag;

import java.util.List;

public class Api {

    private static Api instance;

    public static Api getInstance(){
        if (instance == null){
            instance = new Api();
        }
        return instance;
    }

    private Api(){
        
    }

    public Benutzer anmelden(String email, String passwort) throws Exception {
        return Backend.getInstance().anmelden(email, passwort);
    }

    public void regristieren(Benutzer user) throws Exception {
        Backend.getInstance().regristieren(user);
    }

    public List<Einkaufsliste> lesenEinkaufslistenHelferUebersicht(Benutzer helfer)throws Exception{
        return null;
    }

    public void einkaufAbschliessen(Einkaufsliste einkaufsliste)throws Exception{

    }

    public void einkaufAbbrechen(Einkaufsliste einkaufsliste)throws Exception{

    }

    public List<Einkaufsliste> lesenEinkaufslistenUebersicht()throws Exception{
        return null;
    }

    public void einkaufAnnehmen(Einkaufsliste einkaufsliste, Benutzer helfer)throws Exception{

    }

    /**
     * @param beduerftiger
     * @return Liste der in Auftrag gestellten Einkaufslisten, nach Uhrzeit sortiert
     */
    public List<Einkaufsliste> lesenEinkaufslistenBeduerftigerUebersicht(Benutzer beduerftiger) throws Exception{
        return null;
    }

    public void abbrechenEinkaufslisteBeduerftiger(Einkaufsliste list) throws Exception{

    }

    public void bearbeitenEinkaufsliste(Einkaufsliste neu) throws Exception{

    }

    public void erstellenEinkaufsliste(Einkaufsliste neu) throws Exception{
        
    }

}
