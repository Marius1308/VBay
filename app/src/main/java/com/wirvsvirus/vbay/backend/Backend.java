package com.wirvsvirus.vbay.backend;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

import com.wirvsvirus.vbay.data.*;

public class Backend {

    private Statement stmt;
    private static Backend backend;
    private ArrayList<Einkaufsliste> einkauflisten = new ArrayList<>();

    private Backend() {

    }
    public static Backend getInstance() {
        if (backend==null) {
            backend=new Backend();
        }
        return backend;

    }

    public static void main(String[] args) {
        Backend backend = new Backend();
        System.out.println(backend.test());
    }

    public void anmelden(String email, String passwort) throws Exception {
        // Datenbank durchsuchen
        if (!passwort.trim().equals(stmt.executeQuery("SELECT passwort FROM BENUTZER WHERE EMAIL='" + email + "'").getString("PASSWORT").trim()))
            ; // +email
        // throw new Exception;
    }

    public void regristieren(Benutzer user) throws Exception {
        stmt.executeUpdate(
                "INSERT INTO BENUTZER(EMAIL, NAME, VORNAME, PLZ, ORT, STRASSE, HAUSNUMMER, TELEFONNUMMER,PASSWORT, ADRESSZUSATZ) VALUES ('"
                        + user.getEmail() + "', '" + user.getName() + "', '" + user.getVorname() + "', " + user.getPlz()
                        + ", " + user.getOrt() + "', '" + user.getStrasseHausnr() + "', "
                        + user.getTelefonNr() + ", '" + user.getPasswort() + "', '" + user.getAdresszusatz()
                        + "')");
        // Datenbankeintrag anlegen
        // PW Hashen?!
    }

    public void einkaufslisteAnlegen(Einkaufsliste list) throws Exception {
        // Datenbankeintrag anlegen
        stmt.executeUpdate(
                "INSERT INTO EINKAUFSLISTE(EMAIL, VON, BIS) VALUES ('"+list.getBeduerftiger().getEmail()+"', timestampValueOf("+list.getUhrBis()+"), timeStampValueOf("+list.getUhrVon()+"))");
    }

    public Einkaufsliste EinkaufslisteAbrufen(int id) throws Exception {
        ResultSet rs = stmt.executeQuery("SELECT * FROM EINKAUFSLISTE WHERE NR_EINKAUFSLISTE=" +id);
        rs.first();
       // Vektor anzeige = new Vector();

        while (!rs.isLast())

            return null;
        return null;
    }

    public Einkaufsliste[] anzeigeÜbersicht() {
        return null;
    }  // Lars


    public void einkaufslisteAnnehmen(Einkaufsliste liste){
        einkauflisten.add(liste);
    }

    public Einkaufsliste[] getAkzeptierteEinkaufsliste(){
        return (Einkaufsliste[]) einkauflisten.toArray();
    }

    public int test() {
        // Connection aufbauen
        Connection con = null;
        try {
            // con =
            // DriverManager.getConnection("jdbc:mysql://localhost:3306/login?user=Py8GEGSvL6&password=YyGqWnGvjO");
            con = DriverManager.getConnection( "jdbc:mysql://remotemysql.com:3306/sample?useSSL=false", "Py8GEGSvL6", "YyGqWnGvjO");
            stmt = con.createStatement();
            return stmt.executeUpdate(
                    "INSERT INTO EINTRAG(NR_EINKAUFSLISTE, MENGE, BEZEICHNUNG) VALUES (1,'1 LITER', 'WASSER')");
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public void passWortVerchlüsselung(String passwort) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(passwort.trim().getBytes());
        byte[] hash = md.digest();
        System.out.println(new String(hash));
    }
}
