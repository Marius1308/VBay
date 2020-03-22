package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.util.SemantikException;
import com.wirvsvirus.vbay.util.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

class UserVerwaltungDelegate {

    public Benutzer anmelden(String email, String passwort) throws SemantikException {
        String[] out = Tool.execPHP( "http://localhost/select.php?query=anmelden&email="+Tool.decodeURL(email));

        try {
            if (!out[1].equals(Tool.passWortVerchlüsselung(passwort))){
                throw new SemantikException("password or email is incorrect!");
            }

            return Tool.createBenutzer(out);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void regristieren(Benutzer user) {
        String[] nutzer = Tool.aufdröselnBenutzer(user);

        try {
            JSONObject jo = Util.fuellenKoordinaten(user);
            JSONObject bottomRight = jo.getJSONObject("MetalInfo").getJSONObject("View").getJSONObject("Result").getJSONObject("Relevance").getJSONObject("LocationId").getJSONObject("MapView").getJSONObject("BottomRight");
            nutzer[8]=bottomRight.getString("Latitude");
            nutzer[9]=bottomRight.getString("Longitude");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Tool.execPHP("INSERT INTO BENUTZER (EMAIL, PASSWORT, NAME, VORNAME, PLZ, ORT, STRASSE, ADRESSZUSATZ, TELEFONNUMMER, BREITENGRAD, LAENGENGRAD) VALUES ('"+nutzer[0]+ "', " +"'"+nutzer[1]+ "', " +"'"+nutzer[2]+ "', " +"'"+nutzer[3]+ "', " +"'"+nutzer[4]+ "', " +"'"+nutzer[5]+ "', " +"'"+nutzer[6]+ "', " +"'"+nutzer[7]+ "', " +"'"+nutzer[8]+ "', " +"'"+nutzer[9]+")");

    }
}

