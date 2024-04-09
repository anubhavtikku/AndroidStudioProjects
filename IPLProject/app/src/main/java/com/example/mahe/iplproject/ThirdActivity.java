package com.example.mahe.iplproject;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase=MainActivity.sqLiteDatabase;
    Button b_cl,b_delall,b_dell;
    EditText et_i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b_cl=findViewById(R.id.button13);
        b_delall=findViewById(R.id.button11);
        b_dell=findViewById(R.id.button12);
        et_i=findViewById(R.id.editText);

        b_cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_i.setText("");
            }
        });

        b_dell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              try {
                    int id=Integer.parseInt(et_i.getText().toString());
                    String query = "delete from Players where PId= "+ id+"";
                    sqLiteDatabase.execSQL(query);
                    et_i.setText("");
                    Toast.makeText(ThirdActivity.this, "Deleted Player with ID" + id, Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                { Toast.makeText(ThirdActivity.this, "Invalid ID", Toast.LENGTH_SHORT).show();}
            }
        });

        b_delall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query="delete from players ";
                sqLiteDatabase.execSQL(query);
                Toast.makeText(ThirdActivity.this, "Deleted Players", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
