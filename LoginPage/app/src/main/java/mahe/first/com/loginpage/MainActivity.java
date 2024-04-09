package mahe.first.com.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btlogin;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView )findViewById(R.id.textView);
        btlogin= (Button) findViewById(R.id.btlogin);
    }

    public void Click(View v)
    {
        tv.setText("Batman");
    }

}
