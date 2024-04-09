package mahe.fourth.com.radio;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener ,SeekBar.OnSeekBarChangeListener,TimePicker.OnTimeChangedListener{
    RadioButton rr,rg;
    RelativeLayout rl;
    SeekBar seekBar;
    TextView tv,t1;
    TimePicker tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg=(RadioButton)findViewById(R.id.radioButton2);
        rr=(RadioButton)findViewById(R.id.radioButton3);
        rl=(RelativeLayout)findViewById(R.id.rl);
        tp=(TimePicker)findViewById(R.id.timePicker);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        tv=(TextView)findViewById(R.id.textView2);
        t1=(TextView)findViewById(R.id.textView3);
        rg.setOnCheckedChangeListener(this);
        rr.setOnCheckedChangeListener(this);
        seekBar.setOnSeekBarChangeListener(this);
        tp.setOnTimeChangedListener(this);
        seekBar.setMax(200);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton,boolean b)
    {
        if(rr.isChecked())
        {
            rl.setBackgroundColor(Color.RED);
        }

        if(rg.isChecked())
        {
            rl.setBackgroundColor(Color.GREEN);
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
        tv.setText("Progress is "+i);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this, "SeekBar Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this, "SeekBar Stoped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute)
    {
        int hr=tp.getCurrentHour();
        int min=tp.getCurrentMinute();
        if(hr<12) {
            tv.setText("Time is " + hr + " hours " + min + "min" + " am ");
            t1.setText("Time is " + hr + " hours " + min + "min" + " am ");
           }
        else
        {
            tv.setText("Time is "+hr+" hours "+min+"min"+" pm  ");
            hr=hr-12;
            t1.setText("Time is " + hr + " hours " + min + "min" + " pm ");
        }
    }
}
