package mahe.fourth.com.webandphone;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.editText);
        tv2 = (TextView) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = tv1.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + n));
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = tv2.getText().toString();
                if (n.length() == 10) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + n));
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Wrong number", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}
