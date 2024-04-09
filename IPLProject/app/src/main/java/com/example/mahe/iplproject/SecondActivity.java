package com.example.mahe.iplproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {
    Button b_insert,b_clear;
    EditText et_id,et_name,et_role,et_country,et_tname;
    SQLiteDatabase sqLiteDatabase=MainActivity.sqLiteDatabase;
    String[] city={"Choose a team","Royal Challengers Bangalore","Sunrisers Hyderabad","Chennai Super Kings","Mumbai Indians","Kings XI Punjab","Rajasthan Royals","Kolkata Knight Riders","Delhi Daredevils"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b_insert=findViewById(R.id.button4);
        b_clear=findViewById(R.id.button5);
        et_id=findViewById(R.id.editText4);
        et_name=findViewById(R.id.editText2);
        et_role=findViewById(R.id.editText3);
        et_country=findViewById(R.id.editText5);
        et_tname=findViewById(R.id.editText6);

        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_id.setText("");
                et_name.setText("");
                et_country.setText("");
                et_role.setText("");
                et_tname.setText("");
            }
        });

        b_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try{    int id=Integer.parseInt(et_id.getText().toString());
                String name=et_name.getText().toString();
                String country=et_country.getText().toString();
                String role=et_role.getText().toString();
                String tname=et_tname.getText().toString();


                if (Arrays.asList(city).contains(tname)) {
                    String query = "insert into Players(PId,PName,Role,Country,Tname) values" +
                            "(" + id + ",'" + name + "','" + role + "','" + country + "','" + tname + "')";


                    sqLiteDatabase.execSQL(query);
                    Toast.makeText(SecondActivity.this, "Record inserted", Toast.LENGTH_SHORT).show();
                    et_id.setText("");
                    et_name.setText("");
                    et_country.setText("");
                    et_role.setText("");
                    et_tname.setText("");
                }
                else
                {
                    Toast.makeText(SecondActivity.this, "Player details not in proper format", Toast.LENGTH_SHORT).show();
                }

            }
            catch (Exception e)
            {    Toast.makeText(SecondActivity.this, "Player details not in proper format", Toast.LENGTH_SHORT).show();
            }

            }
        });
    }
}
