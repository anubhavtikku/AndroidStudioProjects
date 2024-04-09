package mahe.sixth.com.game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    Button bt,bt1;
    String aKey="key";
    int u=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        bt1=(Button)findViewById(R.id.button2);
        sp=getSharedPreferences("MyPref",MODE_PRIVATE);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                Intent i=getIntent();
                String us = i.getStringExtra("score");
                u=Integer.parseInt(us);
                SharedPreferences.Editor editor=sp.edit();
                String x=""+u;
                editor.putString(aKey,x);
                editor.commit();
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String s="";
            s=sp.getString(aKey,"");
            alertMag(s);
            }
        });

    }

    void alertMag(String msg)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("High Score");
        builder.setIcon(R.mipmap.ic_launcher_round);
        msg=sp.getString(aKey,"");
        builder.setMessage(msg);
        builder.create();
        builder.show();
    }


}

