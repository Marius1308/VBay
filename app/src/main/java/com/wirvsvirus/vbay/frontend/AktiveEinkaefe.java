package com.wirvsvirus.vbay.frontend;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.marius.vbay.R;
import com.wirvsvirus.vbay.backend.Api;
import com.wirvsvirus.vbay.data.Benutzer;
import com.wirvsvirus.vbay.data.Einkaufsliste;
import com.wirvsvirus.vbay.data.Eintrag;

import java.time.LocalDateTime;
import java.util.List;


public class AktiveEinkaefe extends AppCompatActivity {

  LinearLayout meineEinkaeufe;
  LinearLayout.LayoutParams layoutParams;
  int width;
  int height;
  Benutzer benutzer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_aktive_einkaeufe);

    meineEinkaeufe = (LinearLayout) findViewById(R.id.meineEinkaeufe);
    layoutParams = new LinearLayout.LayoutParams(meineEinkaeufe.getLayoutParams());
    layoutParams.setMargins(0,0,0,20);

    Bundle extras = getIntent().getExtras();
    benutzer = (Benutzer) extras.getSerializable("benutzer");

    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    width = size.x;
    height = size.y;

   updateListe();
  }

  protected void onStart() {
    super.onStart();
    updateListe();
  }

  private void updateListe(){
    meineEinkaeufe.removeAllViews();

    List<Einkaufsliste> listen;

    try {
      listen = Api.getInstance().lesenEinkaufslistenHelferUebersicht(benutzer);
      for(Einkaufsliste liste: listen){
        addToMeineEinkaefe(liste.getBeduerftiger().getVorname() + " " + liste.getBeduerftiger().getName(), liste.getUhrVon().toString(), liste.getUhrBis().toString(), liste);
      }

    } catch (Exception e) {
      e.printStackTrace();
      addToMeineEinkaefe("Max Muster", "05.06.20","01.04.20", null);

  }}

  private void addToMeineEinkaefe(String name, final String uhrBis, final String uhrVon, Einkaufsliste liste){
    LinearLayout newRow = new LinearLayout(this);
    LinearLayout rowInfo = new LinearLayout(this);
    rowInfo.setOrientation(LinearLayout.VERTICAL);


    TextView nameText = new TextView(this);
    TextView uhrBisText = new TextView(this);
    TextView uhrVonText = new TextView(this);
    Button detail = new Button(this);


    nameText.setText("Name: " + name);
    uhrVonText.setText("Seit: " + uhrVon);
    uhrBisText.setText("Bis: "+ uhrBis);
    detail.setText("Show");
    detail.setLayoutParams(new ViewGroup.LayoutParams(
      ViewGroup.LayoutParams.WRAP_CONTENT,
      ViewGroup.LayoutParams.MATCH_PARENT));
    nameText.setWidth(width/4*3);
    uhrBisText.setWidth(width/4*3);
    uhrVonText.setWidth(width/4*3);
    detail.setWidth(width/4);

    detail.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        showDetailPage(liste);
      }
    });

    rowInfo.addView(nameText);
    rowInfo.addView(uhrVonText);
    rowInfo.addView(uhrBisText);

    newRow.addView(rowInfo);
    newRow.addView(detail);

    meineEinkaeufe.addView(newRow, layoutParams);
  }

  private void showDetailPage(Einkaufsliste liste){

    if(liste != null){
      Intent intent;
      intent = new Intent(this, EinkaufAbschliessen.class);
      intent.putExtra("liste", liste);
      intent.putExtra("benuzter", benutzer);
      startActivity(intent);

    }

    //todo Remove:
    Intent intent;
    intent = new Intent(this, EinkaufAbschliessen.class);
    //intent.putExtra("liste", liste);
    //intent.putExtra("benuzter", benutzer);
    startActivity(intent);

  }
}


