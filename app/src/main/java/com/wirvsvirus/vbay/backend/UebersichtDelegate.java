package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;

import java.util.List;

public class UebersichtDelegate {


    public List<EinkaufslisteUebersicht> lesenEinkaufslistenHelferUebersicht(Benutzer helfer) {
        /*
        SELECT el.NR_EINKAUFSLISTE, el.EMAIL, el.VON, el.BIS, bed.NAME, bed.VORNAME, bed.BREITENGRAD, bed.LAENGENGRAD
        FROM EINKAUFSLISTE el
        INNER JOIN BENUTZER bed ON el.EMAIL = bed.EMAIL
        WHERE el.EMAIL_HELFER = ?
         */
        //Add helfer to each el element

        //rdy
        return null;
    }

    public List<EinkaufslisteUebersicht> lesenEinkaufslistenBeduerftigerUebersicht(Benutzer beduerftiger) {
         /*
        SELECT el.NR_EINKAUFSLISTE, el.EMAIL, el.VON, el.BIS, hel.NAME, hel.VORNAME, hel.LAENGENGRAD, hel.BREITENGRAD
        FROM EINKAUFSLISTE el
        INNER JOIN BENUTZER bed ON el.EMAIL = hel.EMAIL
        WHERE el.EMAIL = ?
         */
         //rdy
        return null;
    }

    public EinkaufslisteDetail lesenDetail(EinkaufslisteUebersicht liste) {

         /*
        SELECT el.NR_EINKAUFSLISTE, el.VON, el.BIS,
        hel.EMAIL, hel.PASSWORT, hel.NAME, hel.VORNAME, hel.PLZ, hel.ORT, hel.STRASSE, hel.ADRESSZUSATZ, hel.TELEFONNUMMER, hel.BREITENGRAD, hel.LAENGENGRAD,
        bed.EMAIL, bed.PASSWORT, bed.NAME, bed.VORNAME, bed.PLZ, bed.ORT, bed.STRASSE, bed.ADRESSZUSATZ, bed.TELEFONNUMMER, bed.BREITENGRAD, bed.LAENGENGRAD
        FROM EINKAUFSLISTE el
        INNER JOIN BENUTZER bed ON el.EMAIL = bed.EMAIL
        LEFT JOIN BENUTZER hel ON el.EMAIL_HELFER = hel.EMAIL
        WHERE el.EMAIL = ?
        AND el.NR_EINKAUFSLISTE = ?
         */

          /*
        SELECT ei.NR_EINTRAG, ei.MENGE, ei.BEZEICHNUNG
        FROM EINTRAG ei
        WHERE ei.EMAIL = ?
        AND el.NR_EINKAUFSLISTE = ?
         */

          //rdy
        return null;
    }

    public List<EinkaufslisteUebersicht> lesenEinkaufslistenUebersicht(Benutzer helfer) {
         /*
        SELECT el.NR_EINKAUFSLISTE, el.EMAIL, el.VON, el.BIS, bed.NAME, bed.VORNAME, bed.LAENGENGRAD, bed.BREITENGRAD
        FROM EINKAUFSLISTE el
        INNER JOIN BENUTZER bed ON el.EMAIL = bed.EMAIL
        WHERE bed.PLZ = ?
         */
         //rdy
        return null;
    }

    public List<EinkaufslisteDetail> lesenDetailUebersicht(Benutzer helfer) {
        return null;
    }
}
