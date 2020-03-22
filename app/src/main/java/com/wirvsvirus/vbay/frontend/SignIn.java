package com.wirvsvirus.vbay.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marius.vbay.R;
import com.wirvsvirus.vbay.backend.Api;
import com.wirvsvirus.vbay.data.Benutzer;

public class SignIn extends AppCompatActivity {

  Button login;
  EditText etEmail;
  EditText etPasswort;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_in);

    login = (Button) findViewById(R.id.buttonLogin);
    etEmail = (EditText) findViewById(R.id.etLoginEmail);
    etPasswort = (EditText) findViewById(R.id.etLoginPaswort);

    login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onLoginPress();
      }
    });

  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  Benutzer benutzer = new Benutzer("a@b.de", "max", "muster",123345, "qwertz", "asd 11", "", "12346123", "1234");

  public void onLoginPress(){

    try {

     //benutzer = Api.getInstance().anmelden(etEmail.getText().toString(), etPasswort.getText().toString());
      Api.getInstance().anmelden(etEmail.getText().toString(), etPasswort.getText().toString()); // Todo switch

    } catch (Exception e){
      //openErrorDialog(e.getMessage());
      //return //Todo Use

    }

    Intent intent;
    intent = new Intent(this, MenuHelfer.class);
    intent.putExtra("benutzer", benutzer);
    intent.putExtra("a", false);
    startActivity(intent);

  }

  private void openErrorDialog(String exception){
    Toast.makeText(getApplicationContext(), exception, Toast.LENGTH_LONG).show();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    Intent intent;
    intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }


}
