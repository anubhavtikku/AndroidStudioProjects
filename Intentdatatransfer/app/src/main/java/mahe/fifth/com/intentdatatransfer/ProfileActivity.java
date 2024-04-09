package mahe.fifth.com.intentdatatransfer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tv1=(TextView)findViewById(R.id.textView2);
        tv2=(TextView)findViewById(R.id.textView4);
        tv3=(TextView)findViewById(R.id.textView6);
        Intent i=getIntent();
        String user = i.getStringExtra("UserName");
        String password =i.getExtras().get("Password").toString();
        int a=i.getIntExtra("Age",0);
        String age=""+a;
        tv1.setText(user);
        tv2.setText(password);
        tv3.setText(age);
    }
}
