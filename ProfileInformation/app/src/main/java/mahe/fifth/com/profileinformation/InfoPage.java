package mahe.fifth.com.profileinformation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoPage extends AppCompatActivity {
TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        tv1=(TextView)findViewById(R.id.textView7);
        Intent i=getIntent();
        String x="";
        String gender=i.getStringExtra("Gender");
        String user = i.getStringExtra("UserName");
        String password =i.getStringExtra("Password");
        String email=i.getStringExtra("Email");
        String contact=i.getStringExtra("Contact");
        String ho="Hobbies: ";
        boolean b1=i.getExtras().getBoolean("Cricket");
        if(b1)
            ho=ho+"Cricket ";
        boolean b2=i.getExtras().getBoolean("Hockey");
        if(b2)
            ho=ho+"Hockey ";
        boolean b3=i.getExtras().getBoolean("Others");
        if(b3)
            ho=ho+"Others ";
        x=x+user+"\n"+password+"\n"+email+"\n"+gender+"\n"+contact+"\n"+ho;
        tv1.setText(x);
    }
}
