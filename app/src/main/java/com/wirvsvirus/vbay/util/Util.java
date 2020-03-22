package com.wirvsvirus.vbay.util;

import android.support.annotation.NonNull;
import android.util.Log;

import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
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

          return calculateDistance(getBreitengrad(beduerftiger), getLaengengrad(beduerftiger), getBreitengrad(helfer), getLaengengrad(helfer));

    }

    private Double getBreitengrad(@NonNull Benutzer user) throws IOException, JSONException {
        if (user.getBreitengrad() == null){
            fuellenKoordinaten(user);
        }
        return user.getBreitengrad();
    }



    private Double getLaengengrad(@NonNull Benutzer user) throws IOException, JSONException {
        //TODO bei der Registrierung
        if (user.getLaengengrad() == null){
            fuellenKoordinaten(user);
        }
        return user.getLaengengrad();
    }

    private void fuellenKoordinaten(Benutzer beduerftiger) throws IOException, JSONException {

        String apiKey = "mevuW44x45HNe9rCHCaXVIJu0kmTvokNC6gIcUFBy5o";
        String searchQuery = beduerftiger.getPlz() + "+" + beduerftiger.getOrt() + "+" + beduerftiger.getStrasseHausnr().replace(' ', '+');
        JSONObject resp = RestClient.getGeocode(searchQuery, apiKey);
        Log.d("fuellenKoordinaten", resp.toString());

        speichernKoordinaten(resp);


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


}
