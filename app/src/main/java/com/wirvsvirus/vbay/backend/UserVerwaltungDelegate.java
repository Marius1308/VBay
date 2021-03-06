package com.wirvsvirus.vbay.backend;

import android.util.Log;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.util.DBConnector;
import com.wirvsvirus.vbay.util.SemantikException;
import com.wirvsvirus.vbay.util.Tool;
import com.wirvsvirus.vbay.util.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserVerwaltungDelegate {


    public Benutzer anmelden(String email, String passwort) throws SemantikException, IOException, ExecutionException, InterruptedException {
        String dataset = new DBConnector().execute("select.php?query=anmelden&email="+Tool.decodeURL(email)).get().get(0);
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
            Util.fuellenKoordinaten(user);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static void registrierenAbschliessen(Benutzer user, JSONObject jo) throws JSONException, IOException {
        JSONObject bottomRight = jo.getJSONObject("MetalInfo").getJSONObject("View").getJSONObject("Result").getJSONObject("Relevance").getJSONObject("LocationId").getJSONObject("MapView").getJSONObject("BottomRight");
        new DBConnector().execute("insert.php?query=/regristieren?email="+user.getEmail()+"&passwort="+user.getPasswort()+"&name="+user.getName()+"&vorname="+user.getVorname()+"&plz="+user.getPlz()+"&ort"+user.getOrt()+"&strasse"+user.getStrasseHausnr()+"&adresszusatz="+user.getAdresszusatz()+"&telefonnummer="+user.getTelefonNr()+"&breitengrad="+bottomRight.getString("Latitude")+"&laengengrad=+"+bottomRight.getString("Longitude"));
        Log.d("fuellenKoordinaten", jo.toString());
    }
}

