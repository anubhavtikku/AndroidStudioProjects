package mahe.fifth.com.intentdatatransfer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,et3;
    Button bt,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ProfileActivity.class);
                String user=et1.getText().toString();
                String pass=et2.getText().toString();
                int k=Integer.parseInt(et3.getText().toString());
                i.putExtra("UserName",user);
                i.putExtra("Password",pass);
                i.putExtra("Age",k);
                startActivity(i);
            }
        });

     bt2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent i=new Intent(MainActivity.this,TouristPlaces.class);
             startActivity(i);
         }
     });

    }
}
