package mahe.fourth.com.colormixer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar sb1,sb2,sb3;
    RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb1=(SeekBar)findViewById(R.id.seekBar4);
        sb2=(SeekBar)findViewById(R.id.seekBar5);
        sb3=(SeekBar)findViewById(R.id.seekBar6);
        rl=(RelativeLayout)findViewById(R.id.rl);
        sb1.setOnSeekBarChangeListener(this);
        sb2.setOnSeekBarChangeListener(this);
        sb3.setOnSeekBarChangeListener(this);
        sb1.setMax(255);
        sb2.setMax(255);
        sb3.setMax(255);
    }

    public void change()
    {
        int i=sb1.getProgress();
        int j=sb2.getProgress();
        int k=sb3.getProgress();

        rl.setBackgroundColor(Color.rgb(i,k,j));
    }
    @Override
    public void onProgressChanged(SeekBar sb1, int progress, boolean fromUser) {
    change();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    change();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    change();
    }
}
