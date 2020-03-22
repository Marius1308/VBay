package com.wirvsvirus.vbay.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.marius.vbay.R;

public class EinkaufAbschliessen extends AppCompatActivity {

  Button abschlussButton;
  Button abbruchButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_einkauf_abschliessen);

    abbruchButton = (Button) findViewById(R.id.abbruch);
    abschlussButton = (Button) findViewById(R.id.abschluss);

    abbruchButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        einkaufAbbrechen();
      }
    });

    abschlussButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        einkaufAbschliessen();
      }
    });

  }

  private void einkaufAbbrechen(){
    Intent intent;
    intent = new Intent(this, MenuHelfer.class);
    //intent.putExtra("description", description);
    startActivity(intent);
  }

  private void einkaufAbschliessen(){
    Intent intent;
    intent = new Intent(this, MenuHelfer.class);
    //intent.putExtra("description", description);
    startActivity(intent);
  }


}
