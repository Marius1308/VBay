package com.wirvsvirus.vbay.util;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Tool {
    private static final String serverEndpoint = "https://homeender.de:443/";
    public static String encodeURL(String url) throws MalformedURLException {
        try {
            String encodeURL= URLEncoder.encode( url, "UTF-8" );
            return encodeURL;
        } catch (UnsupportedEncodingException e) {
            return "Fehler beim encoding" +e.getMessage();
        }
    }

    public static String decodeURL(String url)  {
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

    public static List<String> callLink(String link) throws IOException {
        URL url = new URL(serverEndpoint + link);
        Log.d("callLinkResponse", "Calling " + serverEndpoint + link);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.connect();
        int responseCode = conn.getResponseCode();
        if (responseCode != 200){
            throw new RuntimeException("Fehler (HttpResponseCode: "+ responseCode + ")");
        }

        Scanner sc = new Scanner(url.openStream());
        List<String> out = new ArrayList<>();
        Log.d("callLinkResponse", "Called " + serverEndpoint + link);
        while(sc.hasNext())
        {
            out.add(sc.nextLine());
            Log.d("callLinkResponse", out.get(out.size() - 1));
        }
        sc.close();
        return out;
    }

//    public static String[] execPHP(String s){
//        return new String[]{""};
//    }

    public static String callLinkSingleString(String s) throws IOException {
        return callLink(s).get(0);
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

    public static EinkaufslisteUebersicht createEinkaufslisteUebersicht(String[] param){
        EinkaufslisteUebersicht liste = new EinkaufslisteUebersicht();
        liste.setEmailBeduerftiger(param[0]);
     //   liste.setUhrVon(param[1]);
      //  liste.setUhrBis(new LocalDateTime(param[2]));
        return new EinkaufslisteUebersicht();
    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    public static EinkaufslisteDetail createEinkaufslisteDetail(String[] param){
        EinkaufslisteDetail liste= new EinkaufslisteDetail();
        Benutzer b = new Benutzer();
        b.setEmail(param[13]);
        b.setName(param[14]);
        b.setVorname(param[15]);
        b.setPlz(Integer.getInteger(param[16]));
        b.setOrt(param[17]);
        b.setStrasseHausnr(param[18]);
        b.setAdresszusatz(param[19]);
        b.setTelefonNr(param[20]);
        b.setBreitengrad(Double.parseDouble(param[21]));
        b.setLaengengrad(Double.parseDouble(param[22]));

        Benutzer h = new Benutzer();
        h.setEmail(param[3]);
        h.setName(param[4]);
        h.setVorname(param[5]);
        h.setPlz(Integer.getInteger(param[6]));
        h.setOrt(param[7]);
        h.setStrasseHausnr(param[8]);
        h.setAdresszusatz(param[9]);
        h.setTelefonNr(param[10]);
        h.setBreitengrad(Double.parseDouble(param[11]));
        h.setLaengengrad(Double.parseDouble(param[12]));

        //List<String> out = Tool.callLink( "http://localhost/ TODO Einträge beschaffen

        liste.setBeduerftiger(b);
        liste.setNrEinkaufsliste(Integer.getInteger(param[0]));
        liste.setUhrVon(LocalDateTime.parse(param[1]));
        liste.setUhrBis(LocalDateTime.parse(param[2]));
    //   liste.setEintraege();                                     TODO
        liste.setHelfer(Optional.of(h));
        return liste;

    }

    public static String[] aufdröselnEinkaufsliste(EinkaufslisteUebersicht l){
        return new String[]{l.getEmailBeduerftiger(),""+l.getUhrVon(),""+l.getUhrBis()};
    }
}
