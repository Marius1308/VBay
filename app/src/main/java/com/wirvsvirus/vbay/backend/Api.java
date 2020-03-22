package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.Einkaufsliste;
import com.wirvsvirus.vbay.data.Eintrag;

import java.util.List;

public class Api {

    private static Api instance;

    private UebersichtDelegate uebersichtDelegate;
    private AnfrageDelegate anfrageDelegate;
    private UserVerwaltungDelegate userVerwaltungDelegate;

    public static Api getInstance(){
        if (instance == null){
            instance = new Api();
        }
        return instance;
    }

    private Api(){
        uebersichtDelegate = new UebersichtDelegate();
        anfrageDelegate = new AnfrageDelegate();
        userVerwaltungDelegate = new UserVerwaltungDelegate();
    }

    public Benutzer anmelden(String email, String passwort) throws Exception {
        return userVerwaltungDelegate.anmelden(email, passwort);
    }

    public void regristieren(Benutzer user) throws Exception {
       userVerwaltungDelegate.regristieren(user);
    }

    public List<Einkaufsliste> lesenEinkaufslistenHelferUebersicht(Benutzer helfer)throws Exception{
        return uebersichtDelegate.lesenEinkaufslistenHelferUebersicht(helfer);
    }

    public void einkaufAbschliessen(Einkaufsliste einkaufsliste)throws Exception{
        anfrageDelegate.einkaufAbschliessen(einkaufsliste);
    }

    public void einkaufAbbrechen(Einkaufsliste einkaufsliste)throws Exception{
        anfrageDelegate.einkaufAbbrechen(einkaufsliste);
    }

    /**
     * @return Liste der in verfügbaren Einkaufslisten, nach Entfernung sortiert
     */
    public List<Einkaufsliste> lesenEinkaufslistenUebersicht() throws Exception{
        return anfrageDelegate.lesenEinkaufslistenUebersicht();
    }

    public void einkaufAnnehmen(Einkaufsliste einkaufsliste, Benutzer helfer)throws Exception{
        anfrageDelegate.einkaufAnnehmen(einkaufsliste,helfer );
    }

    /**
     * @param beduerftiger
     * @return Liste der in Auftrag gestellten Einkaufslisten, nach Uhrzeit sortiert
     */
    public List<Einkaufsliste> lesenEinkaufslistenBeduerftigerUebersicht(Benutzer beduerftiger) throws Exception{
        return uebersichtDelegate.lesenEinkaufslistenBeduerftigerUebersicht(beduerftiger);
    }

    public void abbrechenEinkaufslisteBeduerftiger(Einkaufsliste liste) throws Exception{
        anfrageDelegate.abbrechenEinkaufslisteBeduerftiger(liste);
    }

    public void bearbeitenEinkaufsliste(Einkaufsliste neu) throws Exception{
        anfrageDelegate.bearbeitenEinkaufsliste(neu);
    }

    public void erstellenEinkaufsliste(Einkaufsliste neu) throws Exception{
        anfrageDelegate.erstellenEinkaufsliste(neu);
    }

}
