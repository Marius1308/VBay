package com.example.marius.vbay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SignIn extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_in);
  }

  public void onBackPressed() {
    super.onBackPressed();
    Intent intent;
    intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }


}
