package mahe.sixth.com.hello;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity{
    EditText et1,et2,et3;
    Button b1,b2;
    SharedPreferences sp;
    String uKey="UserKey",pkey="PassKey",aKey="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        sp=getSharedPreferences("MyPref",MODE_PRIVATE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String user=et1.getText().toString();
               String pass=et3.getText().toString();
               String age1=et2.getText().toString();
               int age;
               age=Integer.parseInt(age1);
               SharedPreferences.Editor editor=sp.edit();
               editor.putString(uKey,user);
               editor.putString(pkey,pass);
               editor.putInt(aKey,age);
               editor.commit();
                Toast.makeText(MainActivity.this,"Data Saved",Toast.LENGTH_SHORT).show();
               et1.setText("");
               et2.setText("");
               et3.setText("");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String user=sp.getString(uKey,"");
               String pass=sp.getString(pkey,"");
               int age=sp.getInt(aKey,0);
                et1.setText(user);
                et3.setText(pass);
                et2.setText(""+age);
            }
        });

    }

}
