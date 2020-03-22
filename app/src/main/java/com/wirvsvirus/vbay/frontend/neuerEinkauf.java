package com.wirvsvirus.vbay.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.marius.vbay.R;
import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.Einkaufsliste;

public class neuerEinkauf extends AppCompatActivity {

  TextView neueListe;
  EditText mengeText;
  EditText nameText;
  Button listeFertig;
  Button hinzufuegenArtikel;
  Benutzer benutzer;
  Einkaufsliste einkaufsliste;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_neuer_einkauf);

    neueListe = (TextView) findViewById(R.id.neueListe);
    mengeText = (EditText) findViewById(R.id.mengeText);
    nameText = (EditText) (findViewById(R.id.nameText));
    listeFertig = (Button) findViewById(R.id.listeFertig);
    hinzufuegenArtikel = (Button) findViewById(R.id.hinzufuegenArtikel);

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

  private void artikelHinzufuegen(){


  }

  private void listeFertig(){

    Intent intent;
    intent = new Intent(this, EinkaufAbschliessen.class);
    //intent.putExtra("liste", liste);
    intent.putExtra("benuzter", benutzer);
    startActivity(intent);
  }

}
