package com.example.mahe.iplproject;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class FourthActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase=MainActivity.sqLiteDatabase;
    Button b_up;
    EditText et_7,et_8;
    String[] city={"Choose a team","Royal Challengers Bangalore","Sunrisers Hyderabad","Chennai Super Kings","Mumbai Indians","Kings XI Punjab","Rajasthan Royals","Kolkata Knight Riders","Delhi Daredevils"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        b_up=findViewById(R.id.button15);
        et_7=findViewById(R.id.editText9);
        et_8=findViewById(R.id.editText8);

        b_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int id = Integer.parseInt(et_7.getText().toString());
                    String tn = et_8.getText().toString();

                    if (Arrays.asList(city).contains(tn)) {
                        String query = "update Players set tname='" + tn + "'where PId=" + id + "";
                        sqLiteDatabase.execSQL(query);
                        et_7.setText("");
                        et_8.setText("");
                        Toast.makeText(FourthActivity.this, "Updated Player with ID" + id, Toast.LENGTH_SHORT).show();
                        }

                     else
                    {
                        Toast.makeText(FourthActivity.this, "Invalid ID or team", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e)
            { Toast.makeText(FourthActivity.this, "Invalid ID or team", Toast.LENGTH_SHORT).show();}

            }
        });

    }
}
