package com.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    Button volver;
    TextView blan,nul,bo,kas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        volver = (Button) findViewById(R.id.btn_volver);
        blan = (TextView) findViewById(R.id.txt_bl);
        nul = (TextView) findViewById(R.id.txt_nul);
        bo = (TextView) findViewById(R.id.txt_bo);
        kas = (TextView) findViewById(R.id.txt_kas);

        Integer Totalblanco=0,Totalnulo=0,Totalbori=0,Totalkast=0;
        SQLiteDatabase db;
        Dbhelper conn = new Dbhelper(getApplicationContext());
        db= conn.getReadableDatabase();
        Cursor C =db.query("voto",null,null,null,null,null,null);
        if(C!=null)
        {
            if(C.moveToFirst())
            {
                do{
                    if(C.getString(2).equals(""))
                    {
                        Totalblanco++;
                    }
                     if(C.getString(2).equals("Nulo"))
                    {
                        Totalnulo++;
                    }
                     if(C.getString(2).equals("Gabriel Boric"))
                    {
                        Totalbori++;
                    }
                     if(C.getString(2).equals("Jose Antonio Kast"))
                    {
                        Totalkast++;
                    }


                }
                while(C.moveToNext());
            }

        }
        blan.setText(""+Totalblanco);
        nul.setText(""+Totalnulo);
        bo.setText(""+Totalbori);
        kas.setText(""+Totalkast);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);
            }
        });
    }
}