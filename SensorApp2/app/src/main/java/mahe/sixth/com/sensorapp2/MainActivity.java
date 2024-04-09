package mahe.sixth.com.sensorapp2;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
     TextView tv_x,tv_y,tv_z;
     SensorManager sensorManager;
     Sensor sensor;
     RelativeLayout relativeLayout;
     MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_x=(TextView)findViewById(R.id.textView);
        tv_y=(TextView)findViewById(R.id.textView2);
        tv_z=(TextView)findViewById(R.id.textView3);
        relativeLayout=(RelativeLayout)findViewById(R.id.rl);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        //sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mediaPlayer=MediaPlayer.create(this,R.raw.yellowc);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensor,sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] v= event.values;
        float x=(int)v[0];
        float y=v[1];
        float z=v[2];
        int x1=(int) x;
        float range=sensor.getMaximumRange();
        int mrange=(int)range;
        /*if((x>=0)&&(x<=5)) {
           // relativeLayout.setBackgroundColor(Color.RED);
            Intent intent=getPackageManager().getLaunchIntentForPackage("com.android.calendar");
            startActivity(intent);
        }*/
        /*else if((x>=-5)&&(x<0))
            relativeLayout.setBackgroundColor(Color.GREEN);
        else
            relativeLayout.setBackgroundColor(Color.BLUE);*/
        if(x1!=mrange)
        {
            mediaPlayer.pause();
        }
        else
        {
            mediaPlayer.start();
        }
        tv_x.setText("X axis values "+x);
        tv_y.setText("Y axis values "+y);
        tv_z.setText("Z axis values "+z);
        Toast.makeText(this,"Range "+range,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
