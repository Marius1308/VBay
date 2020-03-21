package com.wirvsvirus.vbay.frontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.marius.vbay.R;


public class EinkaufAbschiessen extends AppCompatActivity {

  LinearLayout meineEinkaeufe;
  LinearLayout.LayoutParams layoutParams;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_einkauf_abschiessen);

    meineEinkaeufe = (LinearLayout) findViewById(R.id.meineEinkaeufe);
    layoutParams = new LinearLayout.LayoutParams(meineEinkaeufe.getLayoutParams());
    layoutParams.setMargins(0,0,0,20);
  }

  private void addToMeineEinkaefe(){
    LinearLayout newRow = new LinearLayout(this);
    LinearLayout rowInfo = new LinearLayout(this);
    rowInfo.setOrientation(LinearLayout.VERTICAL);

    TextView distanceText = new TextView(this);
    TextView dateText = new TextView(this);
    TextView nameText = new TextView(this);
    Button AbgabeButton = new Button(this);

    //distanceText.setText("Entfernung: " + distance);
    //dateText.setText("Datum: "+ date);
    //AbgabeButton.setText("Abgeben");
    //AbgabeButton.setLayoutParams(new ViewGroup.LayoutParams(
     // ViewGroup.LayoutParams.WRAP_CONTENT,
    //  ViewGroup.LayoutParams.MATCH_PARENT));
    //distanceText.setWidth(width/4*3);
   // dateText.setWidth(width/4*3);
   // nameText.setWidth(width/4*3);
   // AbgabeButton.setWidth(width/4);

    AbgabeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //showDetailPage(description);
      }
    });

    rowInfo.addView(dateText);
    rowInfo.addView(distanceText);
    rowInfo.addView(nameText);

    newRow.addView(rowInfo);
    newRow.addView(AbgabeButton);

    meineEinkaeufe.addView(newRow, layoutParams);
  }
}
