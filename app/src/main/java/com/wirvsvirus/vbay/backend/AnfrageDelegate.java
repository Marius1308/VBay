package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;

import java.util.List;

class AnfrageDelegate {

    public void einkaufAbschliessen(EinkaufslisteDetail einkaufsliste) {
        /*
            DELETE FROM EINTRAG
            WHERE EMAIL = ? AND NR_EINKAUFSLISTE = ?
         */
        /*
            DELETE FROM EINKAUFSLISTE
            WHERE EMAIL = ? AND NR_EINKAUFSLISTE = ?
         */
    }

    public void einkaufAbbrechen(EinkaufslisteDetail einkaufsliste) {
        /*
        UPDATE EINKAUFSLISTE SET EMAIL_HELFER = (NULL)
        WHERE EMAIL = ? AND NR_EINKAUFSLISTE = ?
         */
    }



    public void einkaufAnnehmen(EinkaufslisteDetail einkaufsliste, Benutzer helfer) {
        /*
        UPDATE EINKAUFSLISTE SET EMAIL_HELFER = ?
        WHERE EMAIL = ? AND NR_EINKAUFSLISTE = ?
         */
    }

    public void abbrechenEinkaufslisteBeduerftiger(EinkaufslisteDetail liste) {
        /*
            DELETE FROM EINTRAG
            WHERE EMAIL = ? AND NR_EINKAUFSLISTE = ?
         */
        /*
            DELETE FROM EINKAUFSLISTE
            WHERE EMAIL = ? AND NR_EINKAUFSLISTE = ?
         */
    }

    public void bearbeitenEinkaufsliste(EinkaufslisteDetail neu) {
         /*
            DELETE FROM EINTRAG
            WHERE EMAIL = ? AND NR_EINKAUFSLISTE = ?
         */

        //for-each
        /*
        INSERT INTO EINTRAG (EMAIL, NR_EINKAUFSLISTE, MENGE, BEZEICHNUNG) VALUES (?, ?, ?, ?)
         */
    }

    public void erstellenEinkaufsliste(EinkaufslisteDetail neu) {
        /*
        INSERT INTO EINKAUFSLISTE (EMAIL, NR_EINKAUFSLISTE, VON, BIS) VALUES (
            (SELECT tmp.EMAIL, MAX(NR_EINKAUFSLISTE) + 1 FROM EINKAUFSLISTE tmp WHERE tmp.EMAIL = ?)
        , ?, ?)
         */

        //for-each
        /*
        INSERT INTO EINTRAG (EMAIL, NR_EINKAUFSLISTE, MENGE, BEZEICHNUN) VALUES (?, ?, ?, ?)
         */
    }
}
