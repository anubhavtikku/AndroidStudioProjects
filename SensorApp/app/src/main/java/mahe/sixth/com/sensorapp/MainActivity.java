package mahe.sixth.com.sensorapp;

import android.app.ListActivity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.List;

public class MainActivity extends ListActivity {
      SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
       sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList=sensorManager.getSensorList(Sensor.TYPE_ALL);
        ArrayAdapter<Sensor> adapter=new ArrayAdapter<Sensor>(this,android.R.layout.simple_list_item_1,sensorList);
        setListAdapter(adapter);
    }
}
