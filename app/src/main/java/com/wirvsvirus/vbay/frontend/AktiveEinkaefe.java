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


public class AktiveEinkaefe extends AppCompatActivity {

  LinearLayout meineEinkaeufe;
  LinearLayout.LayoutParams layoutParams;
  int width;
  int height;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_aktive_einkaeufe);

    meineEinkaeufe = (LinearLayout) findViewById(R.id.meineEinkaeufe);
    layoutParams = new LinearLayout.LayoutParams(meineEinkaeufe.getLayoutParams());
    layoutParams.setMargins(0,0,0,20);

    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    width = size.x;
    height = size.y;

    addToMeineEinkaefe("Test", "Ein Test");
    addToMeineEinkaefe("Test2", "Zwei Test");
  }

  private void addToMeineEinkaefe(String name, final String beschreibung){
    LinearLayout newRow = new LinearLayout(this);
    LinearLayout rowInfo = new LinearLayout(this);
    rowInfo.setOrientation(LinearLayout.VERTICAL);

    TextView nameText = new TextView(this);
    TextView beschreibungText = new TextView(this);
    Button detail = new Button(this);


    nameText.setText("Name: " + name);
    beschreibungText.setText("Beschreibung: " + beschreibung);
    detail.setText("Show");
    detail.setLayoutParams(new ViewGroup.LayoutParams(
      ViewGroup.LayoutParams.WRAP_CONTENT,
      ViewGroup.LayoutParams.MATCH_PARENT));
    nameText.setWidth(width/4*3);
    beschreibungText.setWidth(width/4*3);
    detail.setWidth(width/4);

    detail.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        showDetailPage(beschreibung);
      }
    });

    rowInfo.addView(nameText);
    rowInfo.addView(beschreibungText);

    newRow.addView(rowInfo);
    newRow.addView(detail);

    meineEinkaeufe.addView(newRow, layoutParams);
  }

  private void showDetailPage(String description){
    Intent intent;
    intent = new Intent(this, EinkaufAbschliessen.class);
    intent.putExtra("description", description);
    startActivity(intent);
  }
}
