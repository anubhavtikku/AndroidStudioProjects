package mahe.sixth.com.mybroadcastapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Anubhav on 12/12/2017.
 */

public class Mycustomreceivor extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"My Custom Receivor ",Toast.LENGTH_SHORT).show();
    }
}
