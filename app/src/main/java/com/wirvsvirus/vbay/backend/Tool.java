package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tool {
    public static String encodeURL(String url) throws MalformedURLException {
        try {
            String encodeURL= URLEncoder.encode( url, "UTF-8" );
            return encodeURL;
        } catch (UnsupportedEncodingException e) {
            return "Fehler beim encoding" +e.getMessage();
        }
    }

    public static String decodeURL(String url) throws MalformedURLException {
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

    public static List<String> execPHP() throws IOException {
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

    public static String[] execPHP(String s){
        return new String[]{""};
    }

    public static String passWortVerchlüsselung(String passwort) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(passwort.trim().getBytes());
        byte[] hash = md.digest();
       return new String(hash);
    }

    public static Benutzer createBenutzer(String[] param){
            Benutzer benutzer = new Benutzer();
        benutzer.setEmail(param[0]);
        benutzer.setName(param[2]);
        benutzer.setVorname(param[3]);
        benutzer.setPlz(Integer.getInteger(param[4]));
        benutzer.setOrt(param[5]);
        benutzer.setStrasseHausnr(param[6]);
        benutzer.setTelefonNr(param[7]);
        benutzer.setBreitengrad(Double.parseDouble(param[8]));
        benutzer.setLaengengrad(Double.parseDouble(param[9]));
        return benutzer;
    }

    public static String[] aufdröselnBenutzer(Benutzer n){
        return new String[]{n.getEmail(),n.getName(),n.getVorname(),""+n.getPlz(),n.getOrt(),n.getStrasseHausnr(),n.getTelefonNr(),""+n.getBreitengrad(),""+n.getLaengengrad()};
    }
}
