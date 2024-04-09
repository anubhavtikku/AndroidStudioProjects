package mahe.fifth.com.placestovisit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Himalaya extends AppCompatActivity {
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_himalaya);
        tv1=(TextView)findViewById(R.id.textView9);
        tv2=(TextView)findViewById(R.id.textView8);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:28.5983,83.9311"));
                startActivity(intent);
            }
        });
        tv2.setText("The Himalayas, or Himalaya, form a mountain range in Asia separating the plains of the Indian subcontinent from the Tibetan Plateau. The Himalayan range has many of the Earth's highest peaks, including the highest, Mount Everest.");
    }
}
