package com.wirvsvirus.vbay.util;

import android.os.AsyncTask;

import com.wirvsvirus.vbay.data.Benutzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DBConnector extends AsyncTask<String, Void, List<String>> {

    private static DBConnector instance;
    public static DBConnector getInstance(){
        if (instance == null){
            instance = new DBConnector();
        }
        return instance;
    }
    @Override
    protected List<String> doInBackground(String... strings) {
        try {
            return Tool.callLink(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
