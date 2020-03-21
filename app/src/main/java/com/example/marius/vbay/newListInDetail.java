package com.example.marius.vbay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class newListInDetail extends AppCompatActivity {

  TextView descriptionDetailText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_list_in_detail);

    descriptionDetailText = (TextView) findViewById(R.id.descriptionDetail);

    Bundle extras = getIntent().getExtras();
    descriptionDetailText.setText("Beschreibung: " + extras.getString("description"));

  }

  @Override
  protected void onStart() {
    super.onStart();
  }
}
