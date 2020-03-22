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
import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;
import com.wirvsvirus.vbay.data.Eintrag;

public class EinkaufAbschliessen extends AppCompatActivity {


  Button abschluss;
  Button abbruch;
  Benutzer benutzer;
  EinkaufslisteUebersicht liste;
  EinkaufslisteDetail listeDetail;
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
    benutzer = (Benutzer) extras.getSerializable("benutzer");
    liste = (EinkaufslisteUebersicht) extras.getSerializable("liste");

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
 }

 private void updateDetails(){

    nameText.setText("Name: " + listeDetail.getBeduerftiger().getVorname() + " " + listeDetail.getBeduerftiger().getName());
    beschreibungText.setText("Beschreibung: " + listeDetail.getNrEinkaufsliste());
    entfernungText.setText("Entfernung: " + "todo"); //todo
    vonText.setText(listeDetail.getUhrVon().toString());
    bisText.setText(listeDetail.getUhrBis().toString());

    String text = "";
    for(Eintrag eintrag: listeDetail.getEintraege()){
      text +=  "\t-" + eintrag.getMenge() + " " + eintrag.getBezeichnung() + " \n";
    }
      listeText.setText(text);
 }

  @Override
  protected void onStart() {
    super.onStart();
    Bundle extras = getIntent().getExtras();
    benutzer = (Benutzer) extras.getSerializable("benutzer");
    liste = (EinkaufslisteUebersicht) extras.getSerializable("liste");
    listeDetail = Api.getInstance().lesenDetail(liste);

    updateDetails();
  }

  private void einkaufAbbruch(){
   try {
     Api.getInstance().einkaufAbbrechen(listeDetail);
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
      Api.getInstance().einkaufAbschliessen(listeDetail);
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
