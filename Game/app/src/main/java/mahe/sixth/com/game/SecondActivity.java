package mahe.sixth.com.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SecondActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    int i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button=(Button)findViewById(R.id.button3);
        imageView=(ImageView)findViewById(R.id.imageView);
        Random r = new Random();
        i2 = r.nextInt(2);
        if(i2==0)
            imageView.setImageResource(R.drawable.scenery);
        else
            imageView.setImageResource(R.drawable.tree);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                if(i2==0)
                 intent.putExtra("UserName","scenery");
                else
                    intent.putExtra("UserName","tree");
                startActivity(intent);
            }
        });
    }


}
