package com.wirvsvirus.vbay.frontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.marius.vbay.R;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Driver;
import com.wirvsvirus.vbay.backend.Backend;

public class EinkaufAbschliessen extends AppCompatActivity {



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_einkauf_abschliessen);

    try {
      Log.d("EinkaufAbschliessenBack", ""+ Backend.getInstance().execPHP());
    } catch (IOException e) {
      Log.d("EinkaufAbschliessenBack", "Error");
      e.printStackTrace();
    }

    Log.d("EinkaufAbschliessenSQL", "onCreate(): Laeuft");

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/Py8GEGSvL6", "Py8GEGSvL6", "YyGqWnGvjO");
      //here sonoo is database name, root is username and password
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from BENUTZER");
      while (rs.next())
        Log.d("EinkaufAbschliessenSQL",rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
      con.close();
    } catch (Exception e) {
      Log.d("EinkaufAbschliessenSQL", e.toString());
    }
    Log.d("EinkaufAbschliessenSQL",  Boolean.toString(executeCommand()));

  }

  private boolean executeCommand(){



    System.out.println("executeCommand");
    Runtime runtime = Runtime.getRuntime();
    try
    {
      Process  mIpAddrProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
      int mExitValue = mIpAddrProcess.waitFor();
      System.out.println(" mExitValue "+mExitValue);
      if(mExitValue==0){
        return true;
      }else{
        return false;
      }
    }
    catch (InterruptedException ignore)
    {
      ignore.printStackTrace();
      System.out.println(" Exception:"+ignore);
    }
    catch (IOException e)
    {
      e.printStackTrace();
      System.out.println(" Exception:"+e);
    }
    return false;
  }
}
