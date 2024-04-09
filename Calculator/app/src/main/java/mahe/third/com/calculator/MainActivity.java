package mahe.third.com.calculator;

import android.support.v7.appcompat.AppCompataActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button add,sub,mult,div;
    EditText et1,et2;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.editText);
        et2=(EditText) findViewById(R.id.editText2);
        add=(Button) findViewById(R.id.button);
        sub=(Button) findViewById(R.id.button2);
        mult=(Button) findViewById(R.id.button3);
        div=(Button) findViewById(R.id.button4);
        result=(TextView) findViewById(R.id.textView);
    }
    public void add(View v)
    {
        String no1 = et1.getText().toString().trim();
        String no2 = et2.getText().toString().trim();
        int n1=Integer.parseInt(no1);
        int n2=Integer.parseInt(no2);
        int res=n1+n2;
        result.setText("Result is "+res);
        et1.setText("");
        et2.setText("");
    }

    public void sub(View v)
    {
        String no1 = et1.getText().toString().trim();
        String no2 = et2.getText().toString().trim();
        int n1=Integer.parseInt(no1);
        int n2=Integer.parseInt(no2);
        int res=n1-n2;
        result.setText("Result is "+res);
        et1.setText("");
        et2.setText("");
    }

    public void mult(View v)
    {
        String no1 = et1.getText().toString().trim();
        String no2 = et2.getText().toString().trim();
        int n1=Integer.parseInt(no1);
        int n2=Integer.parseInt(no2);
        int res=n1 * n2;
        result.setText("Result is "+res);
        et1.setText("");
        et2.setText("");
    }

    public void div(View v)
    {
        String no1 = et1.getText().toString().trim();
        String no2 = et2.getText().toString().trim();
        int n1=Integer.parseInt(no1);
        int n2=Integer.parseInt(no2);
        int res;

        if(n2!=0) {
            res = n1 / n2;
            result.setText("Result is " + res);
        }
        else
        {
            result.setText("Result is infinity");
        }

        et1.setText("");
        et2.setText("");
    }
}
