package mahe.sixth.com.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
 BluetoothAdapter bluetoothAdapter;
 ToggleButton toggleButton;
 Button button;
 TextView tv;
 ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        button=(Button)findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bluetoothAdapter != null)
                {  if(toggleButton.isChecked())
                {     if(!bluetoothAdapter.isEnabled())
                {   imageView.setImageResource(R.mipmap.tree);
                    Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(intent);

                }

                }

                else
                {
                    bluetoothAdapter.disable();
                    imageView.setImageResource(R.mipmap.ic_launcher_round);
                }

                }

                else
                {
                    Toast.makeText(MainActivity.this, "Bluetooth not enabled ", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="";
                imageView.setImageResource(R.mipmap.ic_launcher);
                Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivity(intent);
                bluetoothAdapter.setName("");
                bluetoothAdapter.startDiscovery();
                Set<BluetoothDevice> device=bluetoothAdapter.getBondedDevices();
                for(BluetoothDevice paireddevice:device)
                {
                    s=s+paireddevice.getName()+"\t"+paireddevice.getBondState();
                }
                tv.setText(s);
            }
        });


    }
}
