package com.example.guessthenumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inditas(View view) {
        EditText probaview=(EditText) findViewById(R.id.proba);
        TextView eredmeny=(TextView) findViewById(R.id.eredmeny);
        EditText sajatszamom=(EditText) findViewById(R.id.sajatszam);
        Random rand=new Random();
        String sajatstring= sajatszamom.getText().toString();

        if(sajatstring.equals(""))
        {
         eredmeny.setText("required a number");
        }
        else {
            guess();


        }





    }

    public void guess()
    {
        EditText probaview=(EditText) findViewById(R.id.proba);
        TextView eredmeny=(TextView) findViewById(R.id.eredmeny);
        EditText sajatszamom=(EditText) findViewById(R.id.sajatszam);

        String sajatertek=sajatszamom.getText().toString();
        int ertek=Integer.parseInt(sajatertek);
        String randertek= probaview.getText().toString();
        int gep=Integer.parseInt(randertek);
        if(ertek==gep)
        {
            eredmeny.setText("You won");
            AlertDialog.Builder altdial = new AlertDialog.Builder(MainActivity.this);
            altdial.setMessage("Do you want to start a new game?").setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            probaview.getText().clear();
                            sajatszamom.getText().clear();


                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }});
            AlertDialog alert = altdial.create();
            alert.setTitle("You won!");
            alert.show();



        }
        else if(ertek<gep)
        {
            eredmeny.setText("Too low");
            sajatszamom.getText().clear();

        }
        else
        {
            eredmeny.setText("Too high");
            sajatszamom.getText().clear();


        }






    }

    public void facebook(View view) {
        Intent facebook=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/David.Kiss17"));
        startActivity(facebook);
    }

    public void exit(View view) {
        finish();
    }

    public void Start(View view) {
        EditText probaview=(EditText) findViewById(R.id.proba);
        Random rand=new Random();
        int szamom = rand.nextInt(100);
        String szam = String.valueOf(szamom);
        probaview.setText(szam);

    }
}