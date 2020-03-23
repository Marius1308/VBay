package com.wirvsvirus.vbay.util;

import android.os.AsyncTask;

import com.wirvsvirus.vbay.backend.UserVerwaltungDelegate;
import com.wirvsvirus.vbay.data.Benutzer;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class NetworkConnector extends AsyncTask<Benutzer, Void, Util.JsonPassUser> {

    private static NetworkConnector instance;
    public static NetworkConnector getInstance(){
        if (instance == null){
            instance = new NetworkConnector();
        }
        return instance;
    }
    @Override
    protected Util.JsonPassUser doInBackground(Benutzer... searchQueries) {
        try {
            Benutzer beduerftiger = searchQueries[0];
            String searchQuery = beduerftiger.getPlz() + "+" + beduerftiger.getOrt() + "+" + beduerftiger.getStrasseHausnr().replace(' ', '+');
            return new Util.JsonPassUser(RestClient.getGeocode(searchQuery), beduerftiger);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    protected void onPostExecute(Util.JsonPassUser feed) {
        try {
            UserVerwaltungDelegate.registrierenAbschliessen(feed.user, feed.jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
