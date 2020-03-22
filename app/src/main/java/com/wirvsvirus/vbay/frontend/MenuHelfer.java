package com.wirvsvirus.vbay.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.marius.vbay.R;
import com.wirvsvirus.vbay.backend.Api;
import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.EinkaufslisteDetail;
import com.wirvsvirus.vbay.data.Eintrag;

import java.util.List;

public class MenuHelfer extends AppCompatActivity {

  Button annehmen;
  Button abschluss;
  Benutzer benutzer;
  TextView liste;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);

    annehmen = (Button) findViewById(R.id.einkaufAnnehmenButton);
    abschluss = (Button) findViewById(R.id.einkaufAbschlussButton);
    liste = (TextView) findViewById(R.id.listeEintrag);

    Bundle extras = getIntent().getExtras();
    benutzer = (Benutzer) extras.getSerializable("benutzer");
    annehmen.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        annehmenPress();
      }
    });

    abschluss.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        abschlussPress();
      }
    });
  }

  @Override
  protected void onStart() {
    super.onStart();
    System.out.println("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeest!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    updateListe();
  }

  private void updateListe() {
    try {
      List<EinkaufslisteDetail> einkaufslisten =  Api.getInstance().lesenDetailUebersicht(benutzer);

      String text = "";
      for(EinkaufslisteDetail liste: einkaufslisten){
        text +="Einkauf von " +  liste.getBeduerftiger().getVorname() + " " + liste.getBeduerftiger().getName() + "\n";
        for(Eintrag eintrag: liste.getEintraege()){
            text += "\t-"+ eintrag.getMenge() + " " + eintrag.getBezeichnung() + "\n";
        }
      }
      liste.setText(text);

    } catch (Exception e) {
      e.printStackTrace();
      liste.setText(e.getMessage());
    }
  }

  public void annehmenPress(){
    Intent intent;
    intent = new Intent(this, EinkaufUebersicht.class);
    intent.putExtra("benutzer", benutzer);
    startActivity(intent);

  }

  public  void abschlussPress(){
    Intent intent;
    intent = new Intent(this, AktiveEinkaefe.class);
    intent.putExtra("benutzer", benutzer);
    startActivity(intent);

  }
}
