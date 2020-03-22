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
import com.wirvsvirus.vbay.data.EinkaufslisteUebersicht;

public class newListInDetail extends AppCompatActivity {

  TextView descriptionDetailText;
  TextView nameText;
  Button accept;
  Benutzer benutzer;
  EinkaufslisteUebersicht liste;
  EinkaufslisteDetail einkaufslisteDetail;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_list_in_detail);

    descriptionDetailText = (TextView) findViewById(R.id.descriptionAbschluss);
    nameText = (TextView) findViewById(R.id.nameDetail);
    accept = (Button) findViewById(R.id.acceptDetail);

    Bundle extras = getIntent().getExtras();
    benutzer = (Benutzer) extras.getSerializable("benutzer");
    liste = (EinkaufslisteUebersicht) extras.getSerializable("liste");

    einkaufslisteDetail = Api.getInstance().le

    accept.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        acceptList();
      }
    });

  }

  private void acceptList(){

    Api.getInstance().einkaufAnnehmen(liste, benutzer);

    Intent intent;
    intent = new Intent(this, MenuHelfer.class);
    startActivity(intent);

  }

  @Override
  protected void onStart() {
    super.onStart();
  }
}
