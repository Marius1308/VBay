package com.wirvsvirus.vbay.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RestClient {

    private static final String urlBlueprint = "https://geocoder.ls.hereapi.com/6.2/geocode.json?apiKey={API_KEY}&searchtext={SEARCH_TEXT}";

    public static JSONObject getGeocode(String searchQuery, String apiKey) throws IOException, JSONException {
        String requestUrl = urlBlueprint.replace("{API_KEY}", apiKey).replace("{SEARCH_TEXT}", searchQuery);
        URL url = new URL(requestUrl);
        checkConnection(url);
        String rep = parseResponse(url);
        return new JSONObject(rep);
    }

    private static void checkConnection(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();
        if (responseCode != 200){
            throw new RuntimeException("Fehler (HttpResponseCode: "+ responseCode + ") Location kann nicht interpretiert werden");
        }
    }

    private static String parseResponse(URL url) throws IOException {
        Scanner sc = new Scanner(url.openStream());
        StringBuffer buf = new StringBuffer();
        while(sc.hasNext())
        {
            buf.append(sc.nextLine());
        }
        sc.close();
        return buf.toString();
    }
}
