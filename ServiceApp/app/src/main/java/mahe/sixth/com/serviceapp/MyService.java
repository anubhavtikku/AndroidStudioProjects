package mahe.sixth.com.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Anubhav on 12/13/2017.
 */

public class MyService extends Service {
    MediaPlayer mediaPlayer;
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Oncreate of service", Toast.LENGTH_SHORT).show();
        mediaPlayer=MediaPlayer.create(this,R.raw.yellowc);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "On start command runs", Toast.LENGTH_SHORT).show();
        if(!mediaPlayer.isPlaying())
        {
            mediaPlayer.start();
            int duration=mediaPlayer.getDuration();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    Toast.makeText(MyService.this, "Song is complete ", Toast.LENGTH_SHORT).show();
                    mediaPlayer.pause();
                    stopSelf();

                }
            });

            Toast.makeText(this, "Duration "+duration, Toast.LENGTH_SHORT).show();
        }

        else
        {
            int position=mediaPlayer.getCurrentPosition();
            Toast.makeText(this, "Already Playing : Position "+position, Toast.LENGTH_SHORT).show();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
        else
        {
            Toast.makeText(this, "Already Stopped ", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}
