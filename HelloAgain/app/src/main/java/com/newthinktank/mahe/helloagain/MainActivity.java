package com.newthinktank.mahe.helloagain;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    Button button;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        notificationManager=(NotificationManager)getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this);
                builder.setContentTitle("My notification");
                builder.setContentText("My new notification is generated ");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                Intent intent=new Intent(MainActivity.this,DescriptionActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,101,intent,0);
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);
                builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
                notificationManager.notify(101,builder.build());
            }
        });


    }
}
