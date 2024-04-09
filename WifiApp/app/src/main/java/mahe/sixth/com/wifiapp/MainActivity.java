package mahe.sixth.com.wifiapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
  ToggleButton toggleButton;
  Button button;
  WifiManager wifiManager;
  MyWifiReceiver myWifiReceiver;
  List<ScanResult> wifiList;
  TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton=(ToggleButton)findViewById(R.id.toggleButton);
        button=(Button)findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView);
        wifiManager=(WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton.isChecked())
                {
                    if(!wifiManager.isWifiEnabled())
                        wifiManager.setWifiEnabled(true);
                    else
                        Toast.makeText(MainActivity.this, "Wifi is already enabled ", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    if(wifiManager.isWifiEnabled())
                    {
                        wifiManager.setWifiEnabled(false);
                    }
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myWifiReceiver = new MyWifiReceiver();

                registerReceiver(myWifiReceiver,new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
                wifiManager.startScan();

                tv.setText("Start Scaning ");
            }
        });

    }

    @Override
    protected void onPause() {
        unregisterReceiver(myWifiReceiver);
        super.onPause();
    }

    @Override
    protected void onResume() {
        registerReceiver(myWifiReceiver,new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        super.onResume();
    }

    class  MyWifiReceiver extends BroadcastReceiver
    {

        @Override
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb=new StringBuilder();

            wifiList=wifiManager.getScanResults();
            sb.append("\n Number of Wifi connections :"+wifiList.size()+"\n\n");

            for (int i=0;i<wifiList.size();i++)
            {
                sb.append(new Integer(i+1).toString()+".");
                sb.append((wifiList.get(i)).toString());
                sb.append("\n\n");
                Toast.makeText(context, ""+sb, Toast.LENGTH_SHORT).show();
            }
            tv.setText(sb);

        }
    }
}
