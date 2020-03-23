package com.wirvsvirus.vbay.util;

import android.support.annotation.NonNull;
import android.util.Log;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;

public class Util {

    public void sortierenEintraege(EinkaufslisteDetail[] liste, Benutzer helfer) {

        Arrays.sort(liste, new Comparator<EinkaufslisteDetail>() {

            @Override
            public int compare(EinkaufslisteDetail o1, EinkaufslisteDetail o2) {
                try {
                    return (int) Math.max(1, Math.min(-1, getDistance(o1.getBeduerftiger(), helfer) - getDistance(o2.getBeduerftiger(), helfer)));
                } catch (IOException|JSONException e){
                    e.printStackTrace();
                    return 0;
                }
            }
        });

    }

    public Double getDistance(Benutzer beduerftiger, Benutzer helfer) throws IOException, JSONException {

          return calculateDistance(beduerftiger.getBreitengrad(), beduerftiger.getLaengengrad(), beduerftiger.getBreitengrad(), beduerftiger.getLaengengrad());

    }

    public static void fuellenKoordinaten(Benutzer beduerftiger) throws IOException, JSONException {
         new NetworkConnector().execute(beduerftiger);

    }

    private void speichernKoordinaten(JSONObject resp) {
        //TODO extract information

        //TODO save to DB
    }

    private double calculateDistance(double breitengrad1, double laengengrad1, double breitengrad2, double laengengrad2) {
        if ((breitengrad1 == breitengrad2) && (laengengrad1 == laengengrad2)) {
            return 0.;
        }

        double theta = laengengrad1 - laengengrad2;
        double dist = Math.sin(Math.toRadians(breitengrad1)) * Math.sin(Math.toRadians(breitengrad2)) + Math.cos(Math.toRadians(breitengrad1)) * Math.cos(Math.toRadians(breitengrad2)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515 * 1.609344;
        return dist;
    }
    

    public static class JsonPassUser{
        public JSONObject jsonObject;
        public Benutzer user;
        public JsonPassUser(JSONObject jsonObject, Benutzer user){
            this.jsonObject = jsonObject;
            this.user = user;
        }
    }
}
