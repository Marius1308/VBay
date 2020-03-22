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

public class EinkaufUebersicht extends AppCompatActivity {
  LinearLayout layout;
  int width;
  int height;
  LinearLayout.LayoutParams layoutParams;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_einkauf_uebersicht);
    layout = (LinearLayout) findViewById(R.id.listEinkaeufe);

    layoutParams = new LinearLayout.LayoutParams(layout.getLayoutParams());
    layoutParams.setMargins(0,0,0,20);

    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    width = size.x;
    height = size.y;
  }

  private void setList(){
    //layout.removeAllViews();
    addToList("20km","12.07.2020", "Eine Milch");
    addToList("200km","12.07.2020", "Eins Einkauf bitte");
    addToList("20km","12.07.2020", "Eine Milch");
    addToList("200km","12.07.2020", "Eins Einkauf bitte");
    addToList("20km","12.07.2020", "Eine Milch");
    addToList("200km","12.07.2020", "Eins Einkauf bitte");
    addToList("20km","12.07.2020", "Eine Milch");
    addToList("200km","12.07.2020", "Eins Einkauf bitte");
    addToList("20km","12.07.2020", "Eine Milch");
    addToList("200km","12.07.2020", "Eins Einkauf bitte");
    addToList("20km","12.07.2020", "Eine Milch");
    addToList("200km","12.07.2020", "Eins Einkauf bitte");
    addToList("20km","12.07.2020", "Eine Milch");
    addToList("200km","12.07.2020", "Eins Einkauf bitte");
    addToList("20km","12.07.2020", "Eine Milch");
    addToList("200km","12.07.2020", "Eins Einkauf bitte");
  }

  private void addToList(String distance, String date, final String description){
    LinearLayout newRow = new LinearLayout(this);
    LinearLayout rowInfo = new LinearLayout(this);
    rowInfo.setOrientation(LinearLayout.VERTICAL);

    TextView distanceText = new TextView(this);
    TextView dateText = new TextView(this);
    TextView nameText = new TextView(this);
    Button detail = new Button(this);
    distanceText.setText("Entfernung: " + distance);
    dateText.setText("Datum: "+ date);
    nameText.setText("Beschreibung: " + description);
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
          showDetailPage(description);
      }
    });

    rowInfo.addView(dateText);
    rowInfo.addView(distanceText);
    rowInfo.addView(nameText);

    newRow.addView(rowInfo);
    newRow.addView(detail);

    layout.addView(newRow, layoutParams);
  }

  private void showDetailPage(String description){
    Intent intent;
    intent = new Intent(this, newListInDetail.class);
    intent.putExtra("description", description);
    startActivity(intent);
  }

  protected void onStart() {
    super.onStart();
  setList();
  System.out.println("Restart");

  }

}
