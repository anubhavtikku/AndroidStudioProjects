package mahe.sixth.com.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_user,et_pass;
    Button btsave,btshow,btvalidate;
    SQLiteDatabase sqLiteDatabase;
    String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_user=(EditText)findViewById(R.id.editText);
        et_pass=(EditText)findViewById(R.id.editText2);
        btsave=(Button)findViewById(R.id.button);
        btshow=(Button)findViewById(R.id.button2);
        btvalidate=(Button)findViewById(R.id.button3);

        sqLiteDatabase=openOrCreateDatabase("DBName",MODE_PRIVATE,null);
        if(sqLiteDatabase!=null)
        {
            Toast.makeText(this,"Database is created",Toast.LENGTH_SHORT).show();
            tablecreate();
            btsave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    username=et_user.getText().toString();
                    password=et_pass.getText().toString();
                    insertData(username,password);
                }
            });

            btshow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fetchdata();
                }
            });

            btvalidate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    username=et_user.getText().toString();
                    password=et_pass.getText().toString();
                    valid(username,password);
                }
            });
        }
        else {
            Toast.makeText(this, "Database not created", Toast.LENGTH_SHORT).show();
        }
    }

    void tablecreate()
    {
        String query="Create table if not exists login (username varchar(32),password varchar(12))";
        sqLiteDatabase.execSQL(query);
        Toast.makeText(this, "Table created", Toast.LENGTH_SHORT).show();

    }

    void  insertData(String u,String p)
    { String query="insert into login values('"+u+"','"+p+"')";
      sqLiteDatabase.execSQL(query);
        Toast.makeText(this, "Data is inserted", Toast.LENGTH_SHORT).show();
    }

    void  fetchdata()
    {  String query="select * from login";
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        String s="";
        while (cursor.moveToNext())
        {
            String user=cursor.getString(0);
            String pass=cursor.getString(1);
            s=s+user+"\t\t\t"+pass+"\n";
        }
        alertMag(s);

    }

    void alertMag(String msg)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Data Stored");
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setMessage(msg);
        builder.create();
        builder.show();
    }

    void valid(String u,String v)
    { String query="select * from login where username='"+u+"' and password='"+v+"'";
      Cursor cursor=sqLiteDatabase.rawQuery(query,null);
      if(cursor.moveToNext())
      {
          Toast.makeText(this, "Valid id ", Toast.LENGTH_SHORT).show();
      }
      else
          Toast.makeText(this, "Invalid id ", Toast.LENGTH_SHORT).show();

    }

}

