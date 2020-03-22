package com.wirvsvirus.vbay.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.marius.vbay.R;
import com.wirvsvirus.vbay.backend.Api;
import com.wirvsvirus.vbay.data.Benutzer;

public class SignUp extends AppCompatActivity {


  EditText etEmail;
  EditText etName;
  EditText etVorname;
  EditText etPlz;
  EditText etOrt;
  EditText etStrasse;
  EditText etAddressZusatz;
  EditText etTele;
  EditText etPasswort;
  Switch aSwitch;
  boolean istHelfer = false;

  Button enter;
  Button login;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up);

    etName = (EditText) findViewById(R.id.etName);
    etEmail = (EditText) findViewById(R.id.etEmail);
    etPasswort = (EditText) findViewById(R.id.etPasswort);
    etVorname = (EditText) findViewById(R.id.etVorname);
    etPlz = (EditText) findViewById(R.id.etPlz);
    etOrt = (EditText) findViewById(R.id.etOrt);
    etStrasse = (EditText) findViewById(R.id.etAdresse);
    enter = (Button) findViewById(R.id.enterButtton);
    login = (Button) findViewById(R.id.login);
    aSwitch = (Switch) findViewById(R.id.switch1);
    enter.setOnClickListener(new View.OnClickListener() {
      @Override
     public void onClick(View view) {

      onEnterPress();
     }
    });

    aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        istHelfer = b;
      }
    });

    login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        zumLogin();
      }
    });


  }

  private void zumLogin(){
    Intent intent;
    intent = new Intent(this, SignIn.class);
    startActivity(intent);
    finish();
  }

  public void onEnterPress(){

    if(!inputIsValid()){
      openErrorDialog("Ungültige Eingabe");
      return;
    }

    Benutzer benutzer = erstelleBenutzer();

    try {
      Api.getInstance().regristieren(benutzer);
      Intent intent;
      intent = new Intent(this, SignIn.class);
      startActivity(intent);

    } catch (Exception e) {
      e.printStackTrace();
      openErrorDialog(e.toString());

    }



  }

  private Benutzer erstelleBenutzer(){
    return new Benutzer(etEmail.getText().toString(),
      etName.getText().toString(),
      etVorname.getText().toString(),
      Integer.parseInt(etPlz.getText().toString()),
      etOrt.getText().toString(),
      etStrasse.getText().toString(),
      etAddressZusatz.getText().toString(),
      etTele.getText().toString(),
      etPasswort.getText().toString(),
      istHelfer);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
  }

  private boolean inputIsValid(){
 return true;
  }

  private void openErrorDialog(String exception){
    Toast.makeText(getApplicationContext(), exception, Toast.LENGTH_LONG).show();
  }

  @Override
  protected void onStart() {
    super.onStart();
  }

}
