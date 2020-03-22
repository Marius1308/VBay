package com.wirvsvirus.vbay.backend;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.util.SemantikException;
import com.wirvsvirus.vbay.util.Tool;
import com.wirvsvirus.vbay.util.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

class UserVerwaltungDelegate {


    public Benutzer anmelden(String email, String passwort) throws SemantikException, IOException {
        String dataset = Tool.callLinkSingleString("select.php?query=anmelden&email="+Tool.decodeURL(email));
        String[] split = dataset.split(";");
        try {
            if (!split[1].equals(Tool.passWortVerchlüsselung(passwort))){
                throw new SemantikException("password or email is incorrect!");
            }

            return Tool.createBenutzer(split);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void regristieren(Benutzer user) {

        try {
            JSONObject jo = Util.fuellenKoordinaten(user);
            JSONObject bottomRight = jo.getJSONObject("MetalInfo").getJSONObject("View").getJSONObject("Result").getJSONObject("Relevance").getJSONObject("LocationId").getJSONObject("MapView").getJSONObject("BottomRight");
            Tool.callLink("/regristieren?email="+user.getEmail()+"&passwort="+user.getPasswort()+"&name="+user.getName()+"&vorname="+user.getVorname()+"&plz="+user.getPlz()+"&ort"+user.getOrt()+"&strasse"+user.getStrasseHausnr()+"&adresszusatz="+user.getAdresszusatz()+"&telefonnummer="+user.getTelefonNr()+"&breitengrad="+bottomRight.getString("Latitude")+"&laengengrad=+"+bottomRight.getString("Longitude"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

