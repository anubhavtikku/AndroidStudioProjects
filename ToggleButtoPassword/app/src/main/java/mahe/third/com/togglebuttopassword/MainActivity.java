package mahe.third.com.togglebuttopassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.security.KeyStore;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    ToggleButton b1;
    EditText et1;
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(ToggleButton)findViewById(R.id.toggleButton2);
        et1=(EditText)findViewById(R.id.editText);

        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {   if(x==1) {
        et1.setTransformationMethod(PasswordTransformationMethod.getInstance());
        x = 0;
       }
       else {
        et1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        x=1;
       }

    }

    }

