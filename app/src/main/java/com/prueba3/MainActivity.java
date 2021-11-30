package com.prueba3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    Button vot,resul;
    RadioButton nul,bo,kast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resul = (Button) findViewById(R.id.btn_resul);
        vot = (Button) findViewById(R.id.btn_voto);
        nul = (RadioButton) findViewById(R.id.rd_nul);
        bo = (RadioButton) findViewById(R.id.rb_bo);
        kast = (RadioButton) findViewById(R.id.rb_ka);

        vot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (nul.isChecked() == false || bo.isChecked() == false || kast.isChecked() == false) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("¿Seguro?")
                            .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    SQLiteDatabase db;
                                    Dbhelper conn = new Dbhelper(getApplicationContext());
                                    db = conn.getReadableDatabase();
                                    ContentValues CV = new ContentValues();
                                    db.insert("Voto", null, CV);
                                    Intent I = new Intent(getApplicationContext(), MainActivity3.class);
                                    startActivity(I);
                                }
                            })
                            .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                    builder.create();
                    builder.show();

                }
                    SQLiteDatabase db;
                    Dbhelper conn = new Dbhelper(getApplicationContext());
                    db = conn.getWritableDatabase();
                    ContentValues CV = new ContentValues();
                    if (nul.isChecked() == true) {
                        CV.put("voto_nulo", "Nulo");
                        db.insert("voto", null, CV);
                        Intent I = new Intent(getApplicationContext(), MainActivity3.class);
                        startActivity(I);
                    }
                    if (bo.isChecked() == true) {
                        CV.put("voto_boric", "Gabriel Boric");
                        db.insert("voto", null, CV);
                        Intent I = new Intent(getApplicationContext(), MainActivity3.class);
                        startActivity(I);
                    }
                    if (kast.isChecked() == true) {
                        CV.put("voto_kast", "Jose Antonio Kast");
                        db.insert("voto", null, CV);
                        Intent I = new Intent(getApplicationContext(), MainActivity3.class);
                        startActivity(I);
                    }


                }

        });
        resul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(I);
            }
        });
    }
}