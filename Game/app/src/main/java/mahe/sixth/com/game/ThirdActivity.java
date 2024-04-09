package mahe.sixth.com.game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ThirdActivity extends AppCompatActivity {
    ImageView imageView;
    SharedPreferences sp;
    TextView textView;
    String aKey="key";
    Button bt, bt1;
    int i2, m = 0;
    int score = 0;
    String q = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        bt = (Button) findViewById(R.id.button4);
        bt1 = (Button) findViewById(R.id.button5);
        String u=sp.getString(aKey,"");
        if(u.equals(""))
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView2);
        sp=getSharedPreferences("MyPref",MODE_PRIVATE);
        Random r = new Random();
        i2 = r.nextInt(2);
        if (i2 == 0) {
            imageView.setImageResource(R.drawable.scenery);
            q = "scenery";
        } else {
            imageView.setImageResource(R.drawable.tree);
            q = "tree";
        }
        Intent i = getIntent();
        String user = i.getStringExtra("UserName");
        if (user.equals(q))
            m = 1;
        else
            m = 0;

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (m == 1) {
                    score++;
                    textView.setText("Score " + score);
                    SharedPreferences.Editor editor=sp.edit();
                    String x=""+score;
                    editor.putString(aKey,x);
                    editor.commit();
                    Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                    startActivity(intent);
                }

                else {
                    Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                    alertMag();
                    intent.putExtra("score", "" + score);
                    startActivity(intent);
                }
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (m == 0) {
                    score++;
                    textView.setText("Score " + score);
                    Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
                else
                    {
                    Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                    alertMag();
                    intent.putExtra("score", "" + score);
                    startActivity(intent);
                }
            }
        });

    }

    void alertMag() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ThirdActivity.this);
        builder.setTitle("Score");
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setMessage(""+score);
        builder.create();
        builder.show();
    }
}