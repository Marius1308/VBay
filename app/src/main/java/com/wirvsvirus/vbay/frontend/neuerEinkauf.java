package com.wirvsvirus.vbay.frontend;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marius.vbay.R;
import com.wirvsvirus.vbay.backend.Api;
import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;
import com.wirvsvirus.vbay.data.Eintrag;

import java.util.List;

public class neuerEinkauf extends AppCompatActivity {

  LinearLayout neueListe;
  EditText mengeText;
  EditText nameText;
  Button listeFertig;
  int width;
  int height;
  Button hinzufuegenArtikel;
  Benutzer benutzer;
  EinkaufslisteDetail einkaufsliste;
  List<Eintrag> eintraege;
  int neuerEintrag = 0;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_neuer_einkauf);

    neueListe = (LinearLayout) findViewById(R.id.neueListe);
    mengeText = (EditText) findViewById(R.id.mengeText);
    nameText = (EditText) (findViewById(R.id.nameText));
    listeFertig = (Button) findViewById(R.id.listeFertig);
    hinzufuegenArtikel = (Button) findViewById(R.id.hinzufuegenArtikel);

    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    width = size.x;
    height = size.y;

    Bundle extras = getIntent().getExtras();
    benutzer = (Benutzer) extras.getSerializable("benutzer");

    listeFertig.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        listeFertig();
      }
    });

    hinzufuegenArtikel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        artikelHinzufuegen();
      }
    });

  }

  @Override
  protected void onStart() {
    super.onStart();
    neuerEintrag = 0;
  }

  private void artikelHinzufuegen(){
    if(mengeText.getText().toString() != "" && nameText.getText().toString() != "")
        eintraege.add(new Eintrag(neuerEintrag, mengeText.getText().toString(), nameText.getText().toString()));
    else
      openErrorDialog("Eintrag nicht vollständig");

    updateListe();
  }

  private void updateListe() {
    neueListe.removeAllViews();
    for(Eintrag eintrag : eintraege){
      LinearLayout row = new LinearLayout(this);
      TextView text = new TextView(this);
      text.setWidth(width /5*4);
      Button loeschen = new Button(this);
      loeschen.setText("löschen");
      text.setText(eintrag.getMenge() +" " + eintrag.getBezeichnung());

      loeschen.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          eintraege.remove(eintrag);
          updateListe();
        }
      });

      row.addView(text);
      row.addView(loeschen);
      neueListe.addView(row);
    }
  }

  private void listeFertig() {

    try {
      Api.getInstance().erstellenEinkaufsliste(einkaufsliste); // Todo
    } catch (Exception e) {
      e.printStackTrace();
    }

    Intent intent;
    intent = new Intent(this, EinkaufAbschliessen.class);
    //intent.putExtra("liste", liste);
    intent.putExtra("benuzter", benutzer);
    startActivity(intent);
  }

  private void openErrorDialog(String exception){
    Toast.makeText(getApplicationContext(), exception, Toast.LENGTH_LONG).show();
  }

}
