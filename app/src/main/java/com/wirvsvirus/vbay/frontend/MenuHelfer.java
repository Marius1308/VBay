package com.wirvsvirus.vbay.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.marius.vbay.R;

public class MenuHelfer extends AppCompatActivity {

  Button annehmen;
  Button abschluss;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);

    annehmen = (Button) findViewById(R.id.einkaufAnnehmenButton);
    abschluss = (Button) findViewById(R.id.einkaufAbschlussButton);

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
  }

  public void annehmenPress(){
    Intent intent;
    intent = new Intent(this, EinkaufUebersicht.class);
    startActivity(intent);
  }

  public  void abschlussPress(){
    Intent intent;
    intent = new Intent(this, AktiveEinkaefe.class);
    startActivity(intent);
  }
}
