package com.example.marius.vbay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class newListInDetail extends AppCompatActivity {

  TextView descriptionDetailText;
  TextView nameText;
  Button backToList;
  Button accept;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_list_in_detail);

    descriptionDetailText = (TextView) findViewById(R.id.descriptionDetail);
    nameText = (TextView) findViewById(R.id.nameDetail);
    backToList = (Button) findViewById(R.id.backDetail);
    accept = (Button) findViewById(R.id.acceptDetail);

    Bundle extras = getIntent().getExtras();
    descriptionDetailText.setText("Beschreibung: " + extras.getString("description"));

    backToList.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        backToOverview();
      }
    });

    accept.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        acceptList();
      }
    });

  }

  private void backToOverview(){
    Intent intent;
    intent = new Intent(this, EinkaufUebersicht.class);
    startActivity(intent);
  }

  private void acceptList(){
    Intent intent;
    intent = new Intent(this, Menu.class);
    startActivity(intent);
  }

  @Override
  protected void onStart() {
    super.onStart();
  }
}
