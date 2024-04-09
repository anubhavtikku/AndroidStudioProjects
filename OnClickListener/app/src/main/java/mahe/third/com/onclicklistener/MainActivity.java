package mahe.third.com.onclicklistener;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b, b1, border;
    ToggleButton tb;
    RelativeLayout relativeLayout;
    CheckBox m, c, t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button2);
        b1 = (Button) findViewById(R.id.button3);
        border = (Button) findViewById(R.id.button);
        tb = (ToggleButton) findViewById(R.id.toggleButton3);
        t = (CheckBox) findViewById(R.id.checkBox);
        c = (CheckBox) findViewById(R.id.checkBox2);
        m = (CheckBox) findViewById(R.id.checkBox3);
        relativeLayout = (RelativeLayout) findViewById(R.id.r1);
        b.setOnClickListener(this);
        b1.setOnClickListener(this);
        tb.setOnClickListener(this);
        border.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:
                Toast.makeText(this, "Hello ", Toast.LENGTH_LONG).show();
                break;

            case R.id.button2:
                Toast.makeText(this, "World ", Toast.LENGTH_LONG).show();
                break;

            case R.id.toggleButton3:
                if (tb.isChecked())
                    relativeLayout.setBackgroundColor(Color.RED);
                else
                    relativeLayout.setBackgroundColor(Color.CYAN);
                break;

            case R.id.button:
                String order = "";
                int x=0;
                if (c.isChecked()) {
                    order = order + "Coffee " + "Rs 10 ";
                    x=x+10;
                    Toast.makeText(this, "Coffee is selected", Toast.LENGTH_SHORT).show();
                }

                if (t.isChecked()) {
                    order = order + "Tea " + "Rs 10 ";
                    x=x+10;
                    Toast.makeText(this, "Tea is selected", Toast.LENGTH_SHORT).show();
                }

                if (m.isChecked()) {
                    order = order + "Milk " + "Rs 10 ";
                    x=x+10;
                    Toast.makeText(this, "Milk is selected", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(this, order, Toast.LENGTH_LONG).show();
                Toast.makeText(this,"Total Bill is "+x, Toast.LENGTH_LONG).show();
                break;


        }
    }
}

