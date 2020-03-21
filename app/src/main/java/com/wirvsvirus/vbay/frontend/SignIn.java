package com.wirvsvirus.vbay.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marius.vbay.R;

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

  public void onLoginPress(){

    try {

    } catch (RuntimeException e){
      openLoginDialog(e.getMessage());
  return;
    }
    Intent intent;
    intent = new Intent(this, Menu.class);
    startActivity(intent);
  }

  private void openLoginDialog(String exception){
    Toast.makeText(getApplicationContext(), exception, Toast.LENGTH_LONG).show();
  }

  public void onBackPressed() {
    super.onBackPressed();
    Intent intent;
    intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }


}
