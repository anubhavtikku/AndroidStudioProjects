package mahe.sixth.com.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

import java.io.File;
import java.util.ArrayList;

public class Player extends AppCompatActivity implements View.OnClickListener {

    static MediaPlayer mp;
    ArrayList<File> mySongs;
    SeekBar seekBar;
    Button bt_ff,bt_fb,bt_next,bt_prev,bt_res;
    int position;
    Uri uri;
    Thread updateSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        bt_res=(Button)findViewById(R.id.button3);
        bt_next=(Button)findViewById(R.id.button5);
        bt_prev=(Button)findViewById(R.id.button6);
        bt_ff=(Button)findViewById(R.id.button4);
        bt_fb=(Button)findViewById(R.id.button);

        bt_fb.setOnClickListener(this);
        bt_ff.setOnClickListener(this);
        bt_res.setOnClickListener(this);
        bt_next.setOnClickListener(this);
        bt_prev.setOnClickListener(this);

        if(mp!=null)
        {
            mp.stop();
            mp.release();
        }

        updateSeekBar=new Thread()
        {
            public  void  run()
            {
                int totalduration=mp.getDuration();
                int currentPosition=0;
                seekBar.setMax(totalduration);
                while (currentPosition<totalduration)
                {
                    try {
                        sleep(500);
                        currentPosition=mp.getCurrentPosition();
                        seekBar.setProgress(currentPosition);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };

        Intent i=getIntent();
        Bundle b=i.getExtras();
        mySongs= (ArrayList)b.getParcelableArrayList("songlist");
        position=b.getInt("pos",0);
        uri=Uri.parse(mySongs.get(position).toString());
        mp=MediaPlayer.create(Player.this,uri);

        mp.start();
        seekBar.setMax(mp.getDuration());
        updateSeekBar.start();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.seekTo(seekBar.getProgress());

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.button3:
                if(mp.isPlaying())
                {   bt_res.setText("||");
                    mp.pause();
                }

                else
                {
                    bt_res.setText(">");
                    mp.start();
                }
                break;

            case R.id.button4:
                mp.seekTo(mp.getCurrentPosition()+5000);
                break;

            case R.id.button:
                mp.seekTo(mp.getCurrentPosition()-5000);
                break;

            case R.id.button5:
                mp.stop();
                mp.release();
                position=(position +1)%mySongs.size();
                uri=Uri.parse(mySongs.get(position).toString());
                mp=MediaPlayer.create(Player.this,uri);

                mp.start();
                break;

            case R.id.button6:
                mp.stop();
                mp.release();
                position=(position-1)<0?mySongs.size()-1 :position-1;
                uri=Uri.parse(mySongs.get(position).toString());
                mp=MediaPlayer.create(Player.this,uri);

                mp.start();
                break;

        }

    }
}
