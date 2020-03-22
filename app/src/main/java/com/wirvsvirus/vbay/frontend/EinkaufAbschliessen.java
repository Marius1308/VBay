package com.wirvsvirus.vbay.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.marius.vbay.R;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import com.mysql.jdbc.Driver;
import com.wirvsvirus.vbay.backend.Api;
import com.wirvsvirus.vbay.backend.Backend;
import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.Einkaufsliste;

public class EinkaufAbschliessen extends AppCompatActivity {


  Button abschluss;
  Button abbruch;
  Benutzer benutzer;
  Einkaufsliste liste;
  TextView nameText;
  TextView beschreibungText;
  TextView entfernungText;
  TextView vonText;
  TextView bisText;
  TextView listeText;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_einkauf_abschliessen);

    abbruch = (Button) findViewById(R.id.abbruch);
    abschluss = (Button) findViewById(R.id.abschluss);
    nameText = (TextView) findViewById(R.id.nameAbschluss);
    beschreibungText = (TextView) findViewById(R.id.descriptionAbschluss);
    entfernungText = (TextView) findViewById(R.id.distanceAbschluss);
    vonText = (TextView) findViewById(R.id.vonAbschluss);
    bisText = (TextView) findViewById(R.id.bisAbbruch);
    listeText = (TextView) findViewById(R.id.eintraegeAbbruch);


    Bundle extras = getIntent().getExtras();
    //benutzer = (Benutzer) extras.getSerializable("benutzer");
    //liste = (Einkaufsliste) extras.getSerializable("liste");

    abbruch.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        einkaufAbbruch();
      }
    });

    abschluss.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        einkaufAbschluss();
      }
    });

    nameText.setText("Name: Max Muster" );
    beschreibungText.setText("Beschreibung: Mein Wocheneinkauf");
    entfernungText.setText("Entfernung: 7 km" ); //todo
    vonText.setText("01.04.20");
    bisText.setText("05.06.20");
    listeText.setText("-2L Milch\n\t -1 Mehl \n\t -6 Eier \n\t -7 Toilettenpapier");

    //updateDetails(); // TODo Switch
 }

 private void updateDetails(){
    nameText.setText("Name: " + liste.getBeduerftiger().getVorname() + " " + liste.getBeduerftiger().getName());
    beschreibungText.setText("Beschreibung: " + liste.getNrEinkaufsliste());
    entfernungText.setText("Entfernung: " + "todo"); //todo
    vonText.setText(liste.getUhrVon().toString());
    bisText.setText(liste.getUhrBis().toString());

      //Todo einträge von liste
 }

  @Override
  protected void onStart() {
    super.onStart();
    Bundle extras = getIntent().getExtras();
    //benutzer = (Benutzer) extras.getSerializable("benutzer");
    //liste = (Einkaufsliste) extras.getSerializable("liste");

   // updateDetails();
  }

  private void einkaufAbbruch(){
   try {
     Api.getInstance().einkaufAbbrechen(liste);
   } catch (Exception e) {
     e.printStackTrace();
   }

   Intent intent;
   intent = new Intent(this, MenuHelfer.class);
   intent.putExtra("benuzter", benutzer);
   startActivity(intent);

 }

  private void einkaufAbschluss(){
    try {
      Api.getInstance().einkaufAbschliessen(liste);
    } catch (Exception e) {
      e.printStackTrace();
    }

    Intent intent;
    intent = new Intent(this, MenuHelfer.class);
    intent.putExtra("benuzter", benutzer);
    intent.putExtra("a", true);
    startActivity(intent);
  }


}
