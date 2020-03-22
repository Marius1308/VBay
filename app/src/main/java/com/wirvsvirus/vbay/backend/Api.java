package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;
import com.wirvsvirus.vbay.frontend.EinkaufUebersicht;

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

    // ---------------- API-Schnittstelle ----------------------

    /**
     * Gibt den Benutzer mit passender email zurück. Gibt Fehler bei falschem Passwort oder nicht existierendem Benutzer
     * @param email
     * @param passwort
     * @return
     * @throws Exception
     */
    public Benutzer anmelden(String email, String passwort) throws Exception {
        return userVerwaltungDelegate.anmelden(email, passwort);
    }

    /**
     * Registrieren des Nutzers in der DB
     * @param user
     * @throws Exception
     */
    public void regristieren(Benutzer user) throws Exception {
       userVerwaltungDelegate.regristieren(user);
    }

    /**
     * Gebe Übersicht der vom Helfer akzeptierten Einkaufslisten
     * @param helfer
     * @return
     * @throws Exception
     */
    public List<EinkaufslisteUebersicht> lesenEinkaufslistenHelferUebersicht(Benutzer helfer)throws Exception{
        return uebersichtDelegate.lesenEinkaufslistenHelferUebersicht(helfer);
    }

    /**
     * Der Einkauf wurde abgegeben und ist daher abgeschlossen
     * @param einkaufsliste
     * @throws Exception
     */
    public void einkaufAbschliessen(EinkaufslisteDetail einkaufsliste)throws Exception{
        anfrageDelegate.einkaufAbschliessen(einkaufsliste);
    }

    /**
     * Der Einkauf wurde angenommen, kann aber nicht erfüllt werden und muss neu zugeteilt werden
     * @param einkaufsliste
     * @throws Exception
     */
    public void einkaufAbbrechen(EinkaufslisteDetail einkaufsliste)throws Exception{
        anfrageDelegate.einkaufAbbrechen(einkaufsliste);
    }

    /**
     * @return Liste der in dem Ort verfügbaren Einkaufslisten, nach Entfernung sortiert
     */
    public List<EinkaufslisteUebersicht> lesenEinkaufslistenUebersicht(Benutzer helfer) throws Exception{
        return uebersichtDelegate.lesenEinkaufslistenUebersicht(helfer);
    }

    /**
     * Liest die detaillierten Daten einer Einkaufsliste
     * @param liste
     */
    public EinkaufslisteDetail lesenDetail(EinkaufslisteUebersicht liste){
        return uebersichtDelegate.lesenDetail(liste);
    }

    /**
     * Liest die detaillierten Daten aller akzeptierten Einkaufslisten
     */
    public List<EinkaufslisteDetail> lesenDetailUebersicht(Benutzer helfer){
        return uebersichtDelegate.lesenDetailUebersicht(helfer);
    }

    /**
     * Helfer nimmt den Auftrag an
     * @param einkaufsliste
     * @param helfer
     * @throws Exception
     */
    public void einkaufAnnehmen(EinkaufslisteDetail einkaufsliste, Benutzer helfer)throws Exception{
        anfrageDelegate.einkaufAnnehmen(einkaufsliste,helfer);
    }

    /**
     * @param beduerftiger
     * @return Liste der in Auftrag gestellten Einkaufslisten, nach Uhrzeit sortiert
     */
    public List<EinkaufslisteUebersicht> lesenEinkaufslistenBeduerftigerUebersicht(Benutzer beduerftiger) throws Exception{
        return uebersichtDelegate.lesenEinkaufslistenBeduerftigerUebersicht(beduerftiger);
    }

    /**
     * Bedürftiger bricht die Einkaufsliste ab, da sie nicht mehr benötigt wird und eh noch nicht angenommen wurde
     * @param liste
     * @throws Exception
     */
    public void abbrechenEinkaufslisteBeduerftiger(EinkaufslisteDetail liste) throws Exception{
        anfrageDelegate.abbrechenEinkaufslisteBeduerftiger(liste);
    }

    /**
     * Bedürftiger möchte Änderungen an seiner Einkaufsliste vornehmen
     * @param neu
     * @throws Exception
     */
    public void bearbeitenEinkaufsliste(EinkaufslisteDetail neu) throws Exception{
        anfrageDelegate.bearbeitenEinkaufsliste(neu);
    }

    /**
     * Erstellen einer neuen Einkaufsliste
     * @param neu
     * @throws Exception
     */
    public void erstellenEinkaufsliste(EinkaufslisteDetail neu) throws Exception{
        anfrageDelegate.erstellenEinkaufsliste(neu);
    }

}
