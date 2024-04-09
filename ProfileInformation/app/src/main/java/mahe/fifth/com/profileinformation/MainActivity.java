package mahe.fifth.com.profileinformation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    CheckBox c1,c2,c3;
    RadioButton r1,r2;
    Button bt;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText4);
        et3=(EditText)findViewById(R.id.editText2);
        et4=(EditText)findViewById(R.id.editText3);
        c1=(CheckBox)findViewById(R.id.checkBox);
        c2=(CheckBox)findViewById(R.id.checkBox2);
        c3=(CheckBox)findViewById(R.id.checkBox3);
        r1=(RadioButton)findViewById(R.id.radioButton2);
        r2=(RadioButton)findViewById(R.id.radioButton3);
        bt=(Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent i = new Intent(MainActivity.this,InfoPage.class);
                String user = et1.getText().toString();
                String pass = et2.getText().toString();
                String email = et3.getText().toString();
                String contact = et4.getText().toString();
                Toast.makeText(MainActivity.this, ""+user+pass+email+contact, Toast.LENGTH_SHORT).show();
                if (r1.isChecked())
                    i.putExtra("Gender", "Male");
                else
                    i.putExtra("Gender", "Female");
                i.putExtra("UserName", user);
                i.putExtra("Password", pass);
                i.putExtra("Email", email);
                i.putExtra("Contact", contact);
                i.putExtra("Cricket", c1.isChecked());
                i.putExtra("Hockey", c2.isChecked());
                i.putExtra("Others", c3.isChecked());
                startActivity(i);
            }
                    });

            }
        }

