package com.example.marius.vbay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EinkaufUebersicht extends AppCompatActivity {
  LinearLayout layout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_einkauf_uebersicht);
    layout = (LinearLayout) findViewById(R.id.listEinkaeufe);

    addToList("20km", "Eine Milch");
    addToList("200km", "Eins Einkauf bitte");
  }

  private void addToList(String distance, String name){
    LinearLayout newRow = new LinearLayout(this);
    TextView distanceText = new TextView(this);
    TextView nameText = new TextView(this);
    Button detail = new Button(this);
    distanceText.setText(distance);
    nameText.setText(name);
    detail.setText("Show");

    detail.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

      }
    });

    newRow.addView(distanceText);
    newRow.addView(nameText);
    newRow.addView(detail);

    layout.addView(newRow);
  }
}
