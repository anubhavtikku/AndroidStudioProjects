package mahe.third.com.calc;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    public void onClick(View v)
    {   String no1 = et1.getText().toString().trim();
        String no2 = et2.getText().toString().trim();
        int n1=Integer.parseInt(no1);
        int n2=Integer.parseInt(no2);
        int res=0,x=0;

        switch (v.getId())
    {case R.id.button:
        res=n1+n2;
        break;

        case R.id.button2:
            res=n1-n2;
            break;

        case R.id.button3:
            res=n1*n2;
            break;

        case R.id.button4:
            if(n2!=0) {
                res = n1 / n2;
            x=0;}
            else
                x=1;
            break;

    }
        et1.setText("");
        et2.setText("");
        if(x==0)
        Toast.makeText(this, "Result is "+res, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Result is infinity", Toast.LENGTH_LONG).show();
    }

}
