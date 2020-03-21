package com.wirvsvirus.vbay.util;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wirvsvirus.vbay.data.Benutzer;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class Util {

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