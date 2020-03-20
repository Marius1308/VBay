package com.example.marius.vbay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

private Button signUpButton;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    signUpButton = (Button) findViewById(R.id.SignUp);
    signUpButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        openSignUp();
      }
    });
  }

  public void openSignUp(){

    Intent intent;
    intent = new Intent(this, SignUp.class);
    startActivity(intent);
  }

}
