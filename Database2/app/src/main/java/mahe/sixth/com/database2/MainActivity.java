package mahe.sixth.com.database2;

import android.content.SharedPreferences;
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
    EditText et_id,et2_user,et3_pass;
    Button b_show,b_save,b_update;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_id = (EditText) findViewById(R.id.editText);
        et2_user = (EditText) findViewById(R.id.editText2);
        et3_pass = (EditText) findViewById(R.id.editText3);
        b_show = (Button) findViewById(R.id.button);
        b_save = (Button) findViewById(R.id.button2);
        b_update = (Button) findViewById(R.id.button3);

        sqLiteDatabase = openOrCreateDatabase("DBName", MODE_PRIVATE, null);
        if (sqLiteDatabase != null) {
            Toast.makeText(this, "Database created", Toast.LENGTH_SHORT).show();
            tablecreate();
            b_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String in = et_id.getText().toString();
                    String u = et2_user.getText().toString();
                    String p = et3_pass.getText().toString();
                    int i=Integer.parseInt(in);
                    insertData(i,u,p);

                }
            });

            b_show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fetchdata();
                }
            });

            b_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    update();
                }
            });
        }
    }

        void tablecreate()
    { String query="Create table if not exists login (id integer(3),username varchar(32),password varchar(12))";
        sqLiteDatabase.execSQL(query);
        Toast.makeText(this, "Table created", Toast.LENGTH_SHORT).show();
    }

    void  insertData(int i,String u,String p)
    { String query="insert into login values("+i+",'"+u+"','"+p+"')";
        sqLiteDatabase.execSQL(query);
        Toast.makeText(this, "Data is inserted", Toast.LENGTH_SHORT).show();
    }

    void  fetchdata()
    {  String query="select * from login";
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        String s="";
        while (cursor.moveToNext())
        {
            String user=cursor.getString(1);
            String pass=cursor.getString(2);
            int l=cursor.getInt(0);
            s=s+l+"\t\t\t"+user+"\t\t\t"+pass+"\n";
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

    void update()
    {   String query="select * from login";
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        int x=0;
        String in = et_id.getText().toString();
        String u = et2_user.getText().toString();
        String p = et3_pass.getText().toString();
        int i=Integer.parseInt(in);

        while (cursor.moveToNext())
        {
            int l=cursor.getInt(0);
            if(l==i)
            {
                x=1;
                break;
            }
        }

        if(x==0)
            Toast.makeText(this, "Id not found", Toast.LENGTH_SHORT).show();
        else
        { query="update login set username='"+u+"',password='"+p+"' where id="+i;
            sqLiteDatabase.execSQL(query);
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
        }

}


}
