package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;

class UserVerwaltungDelegate {

    public Benutzer anmelden(String email, String passwort) {
        /*
        SELECT EMAIL, PASSWORT, NAME, VORNAME, PLZ, ORT, STRASSE, ADRESSZUSATZ, TELEFONNUMMER, BREITENGRAD, LAENGENGRAD FROM BENUTZER WHERE EMAIL = ?
         */

        //PASSWORT PRÜFEN
        return null;
    }

    public void regristieren(Benutzer user) {
        //Breiten- /Längengrad errechnen
        /*
         * INSERT INTO BENUTZER (EMAIL, PASSWORT, NAME, VORNAME, PLZ, ORT, STRASSE, ADRESSZUSATZ, TELEFONNUMMER, BREITENGRAD, LAENGENGRAD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
         *
         */
    }
}
