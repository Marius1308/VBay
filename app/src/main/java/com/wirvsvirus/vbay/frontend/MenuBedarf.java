package com.wirvsvirus.vbay.frontend;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.marius.vbay.R;
import com.wirvsvirus.vbay.backend.Api;
import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;

import java.util.List;

public class MenuBedarf extends AppCompatActivity {

  LinearLayout textAuftaegeBearbeitet;
  LinearLayout textAuftraegeWarten;
  Button neuerEinkauf;
  Benutzer benutzer;
  int width;
  int height;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu_bedarf);

    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    width = size.x;
    height = size.y;

    Bundle extras = getIntent().getExtras();
    benutzer = (Benutzer) extras.getSerializable("benutzer");

    textAuftaegeBearbeitet = (LinearLayout) findViewById(R.id.textAuftaegeBearbeitet);
    textAuftraegeWarten = (LinearLayout) findViewById(R.id.textAuftraegeWarten);

    neuerEinkauf = (Button) findViewById(R.id.neueListe);


    neuerEinkauf.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        neuerEinkauf();
      }
    });

  }

  @Override
  protected void onStart() {
    super.onStart();
    updateListen();
  }

  private void updateListen() {

    try {
      List<EinkaufslisteUebersicht> listen = Api.getInstance().lesenEinkaufslistenBeduerftigerUebersicht(benutzer);
      for(EinkaufslisteUebersicht liste: listen){
        if(liste.getNameHelfer() != null)
          newRowBearbeiten(liste);
        else
          newRowWarten(liste);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private void newRowBearbeiten(EinkaufslisteUebersicht liste){
    LinearLayout newRow = new LinearLayout(this);
    LinearLayout lines = new LinearLayout(this);
    lines.setOrientation(LinearLayout.VERTICAL);
    newRow.setOrientation(LinearLayout.HORIZONTAL);
    Button showDetail = new Button(this);
    TextView textHelfer = new TextView(this);
    TextView textName = new TextView(this);

    textHelfer.setText("Einkäufer: " + liste.getVorHelfer() + " " + liste.getNameHelfer());
    textName.setText("Bis: " + liste.getUhrBis().toString());
    textHelfer.setWidth(width/4*3);
    textName.setWidth(width/4*3);

    lines.addView(textName);
    lines.addView(textHelfer);

    newRow.addView(lines);
    newRow.addView(showDetail);

    textAuftaegeBearbeitet.addView(newRow);
  }

  private void newRowWarten(EinkaufslisteUebersicht liste){
    LinearLayout newRow = new LinearLayout(this);
    LinearLayout lines = new LinearLayout(this);
    lines.setOrientation(LinearLayout.VERTICAL);
    newRow.setOrientation(LinearLayout.HORIZONTAL);
    Button showDetail = new Button(this);
    TextView textHelfer = new TextView(this);
    TextView textName = new TextView(this);

    textHelfer.setText("Von: " + liste.getUhrVon() + " " + liste.getNameHelfer());
    textName.setText("Bis: " + liste.getUhrBis().toString());
    textHelfer.setWidth(width/4*3);
    textName.setWidth(width/4*3);

    lines.addView(textName);
    lines.addView(textHelfer);

    newRow.addView(lines);
    newRow.addView(showDetail);

    textAuftaegeBearbeitet.addView(newRow);
  }

  public void neuerEinkauf(){
    Intent intent;
    intent = new Intent(this, EinkaufUebersicht.class);
    intent.putExtra("benutzer", benutzer);
    startActivity(intent);
  }

}
