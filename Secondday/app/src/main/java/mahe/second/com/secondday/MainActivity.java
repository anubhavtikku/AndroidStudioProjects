package mahe.second.com.secondday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button but;
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but=(Button)findViewById(R.id.bt);
        t1=(TextView )findViewById(R.id.et1);
        t2=(TextView )findViewById(R.id.et2);

    }

    public void click(View v)
    {
        String a,b;
        a=t1.getText().toString();
        b=t2.getText().toString();
        t1.setText(b);
        t2.setText(a);
    }
}
