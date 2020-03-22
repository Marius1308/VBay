package com.wirvsvirus.vbay.backend;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.wirvsvirus.vbay.data.*;

public class Backend {

    private Statement stmt;
    private static Backend backend;
    private ArrayList<EinkaufslisteDetail> einkauflisten = new ArrayList<>();

    private Backend() {

    }

    public static Backend getInstance() {
        if (backend==null) {
            backend=new Backend();
        }
        return backend;

    }

    public static void main(String[] args) {
        System.out.println(Backend.getInstance().test());
    }

    public Benutzer anmelden(String email, String passwort) throws Exception {
        // Datenbank durchsuchen
        if (!passwort.trim().equals(stmt.executeQuery("SELECT passwort FROM BENUTZER WHERE EMAIL='" + email + "'").getString("PASSWORT").trim()))
            ; // +email
        // throw new Exception;
        return null;
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

    public void einkaufslisteAnlegen(EinkaufslisteDetail list) throws Exception {
        // Datenbankeintrag anlegen
        stmt.executeUpdate(
                "INSERT INTO EINKAUFSLISTE(EMAIL, VON, BIS) VALUES ('"+list.getBeduerftiger().getEmail()+"', timestampValueOf("+list.getUhrBis()+"), timeStampValueOf("+list.getUhrVon()+"))");
    }

    public EinkaufslisteDetail EinkaufslisteAbrufen(int id) throws Exception {
        ResultSet rs = stmt.executeQuery("SELECT * FROM EINKAUFSLISTE WHERE NR_EINKAUFSLISTE=" +id);
        rs.first();
       // Vektor anzeige = new Vector();

        while (!rs.isLast())

            return null;
        return null;
    }

    public EinkaufslisteDetail[] anzeigeÜbersicht() {
        return null;
    }  // Lars


    public void einkaufslisteAnnehmen(EinkaufslisteDetail liste){
        einkauflisten.add(liste);
    }

    public EinkaufslisteDetail[] getAkzeptierteEinkaufsliste(){
        return (EinkaufslisteDetail[]) einkauflisten.toArray();
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

    public String encodeURL(String url) throws MalformedURLException {
        try {
            String encodeURL= URLEncoder.encode( url, "UTF-8" );
            return encodeURL;
        } catch (UnsupportedEncodingException e) {
            return "Fehler beim encoding" +e.getMessage();
        }
    }

    public String decodeURL(String url) throws MalformedURLException {
        try {
            String prevURL="";
            String decodeURL=url;
            while(!prevURL.equals(decodeURL))
            {
                prevURL=decodeURL;
                decodeURL= URLDecoder.decode( decodeURL, "UTF-8" );
            }
            return decodeURL;
        } catch (UnsupportedEncodingException e) {
            return "Fehler beim decoding" +e.getMessage();
        }
    }

    public List<String> execPHP() throws IOException {
        URL url = new URL("https://localhost/insert.php?query=INSERT+INTO+%60eintrag%60+%28%60NR_EINKAUFSLISTE%60%2C+%60MENGE%60%2C+%60BEZEICHNUNG%60%29+VALUES+%28%271%27%2C+%271+Liter%27%2C+%27Wasser%27%29");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();
        if (responseCode != 200){
            throw new RuntimeException("Fehler (HttpResponseCode: "+ responseCode + ") Location kann nicht interpretiert werden");
        }

        Scanner sc = new Scanner(url.openStream());
        List<String> out = new ArrayList<>();
        while(sc.hasNext())
        {
            out.add(sc.nextLine());
        }
        sc.close();
        return out;
    }
}
