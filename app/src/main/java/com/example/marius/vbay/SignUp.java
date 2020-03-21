package com.example.marius.vbay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

  EditText etName;
  EditText etEmail;
  EditText etPasswort;
  Button enter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up);

    etName = (EditText) findViewById(R.id.etName);
    etEmail = (EditText) findViewById(R.id.etEmail);
    etPasswort = (EditText) findViewById(R.id.etPasswort);
    enter = (Button) findViewById(R.id.enterButtton);
    enter.setOnClickListener(new View.OnClickListener() {
      @Override
     public void onClick(View view) {

      onEnterPress();
     }
    });


  }

  public void onEnterPress(){

    try {

    }catch (RuntimeException e){
      openEnterDialog(e.getMessage());
      return;
    }


    System.out.println(etPasswort.getText().toString());
    Intent intent;
    intent = new Intent(this, SignIn.class);
    startActivity(intent);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
  }

  private boolean inputIsValid(){
 return true;
  }

  private void openEnterDialog(String exception){
    Toast.makeText(getApplicationContext(), exception, Toast.LENGTH_LONG).show();
  }

}
