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
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;

public class EinkaufUebersicht extends AppCompatActivity {
  LinearLayout layout;
  int width;
  int height;
  Benutzer benutzer;
  LinearLayout.LayoutParams layoutParams;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_einkauf_uebersicht);
    layout = (LinearLayout) findViewById(R.id.listEinkaeufe);

    Bundle extras = getIntent().getExtras();
    benutzer = (Benutzer) extras.getSerializable("benutzer");

    layoutParams = new LinearLayout.LayoutParams(layout.getLayoutParams());
    layoutParams.setMargins(0,0,0,20);

    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    width = size.x;
    height = size.y;
  }

  private void setList(){
    layout.removeAllViews();

    try {
      for(EinkaufslisteUebersicht liste : Api.getInstance().lesenEinkaufslistenUebersicht(benutzer)){
        addToList(liste);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void addToList(EinkaufslisteUebersicht liste){
    LinearLayout newRow = new LinearLayout(this);
    LinearLayout rowInfo = new LinearLayout(this);
    rowInfo.setOrientation(LinearLayout.VERTICAL);

    TextView distanceText = new TextView(this);
    TextView dateText = new TextView(this);
    TextView nameText = new TextView(this);
    Button detail = new Button(this);
    distanceText.setText("Entfernung: " + liste.getEntfernung());
    dateText.setText("Von: "+ liste.getUhrVon());
    nameText.setText("Bis: " + liste.getUhrBis());
    detail.setText("Show");
    detail.setLayoutParams(new ViewGroup.LayoutParams(
      ViewGroup.LayoutParams.WRAP_CONTENT,
      ViewGroup.LayoutParams.MATCH_PARENT));
    distanceText.setWidth(width/4*3);
    dateText.setWidth(width/4*3);
    nameText.setWidth(width/4*3);
    detail.setWidth(width/4);

    detail.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          showDetailPage(liste);
      }
    });

    rowInfo.addView(dateText);
    rowInfo.addView(distanceText);
    rowInfo.addView(nameText);

    newRow.addView(rowInfo);
    newRow.addView(detail);

    layout.addView(newRow, layoutParams);
  }

  private void showDetailPage(EinkaufslisteUebersicht liste){
    Intent intent;
    intent = new Intent(this, newListInDetail.class);
    intent.putExtra("benutzer", benutzer);
    intent.putExtra("liste", liste);
    startActivity(intent);
  }

  protected void onStart() {
    super.onStart();
  setList();
  System.out.println("Restart");

  }

}
