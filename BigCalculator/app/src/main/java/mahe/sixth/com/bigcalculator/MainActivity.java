package mahe.sixth.com.bigcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b[]=new Button[16];
    TextView et;
    int x=0,y=0,z=0;
    String o="";
    String q="";

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (TextView) findViewById(R.id.textView);
        b[1] = (Button)findViewById(R.id.button);
        b[2] = (Button)findViewById(R.id.button2);
        b[3] = (Button)findViewById(R.id.button3);
        b[4] = (Button)findViewById(R.id.button4);
        b[5] = (Button)findViewById(R.id.button5);
        b[6] = (Button)findViewById(R.id.button6);
        b[7] = (Button)findViewById(R.id.button8);
        b[8] = (Button)findViewById(R.id.button9);
        b[9] = (Button)findViewById(R.id.button10);
        b[0] = (Button)findViewById(R.id.button12);
        b[10] = (Button)findViewById(R.id.button13);
        b[11] = (Button)findViewById(R.id.button16);
        b[12] = (Button)findViewById(R.id.button7);
        b[13] =(Button) findViewById(R.id.button11);
        b[14] = (Button)findViewById(R.id.button15);
        b[15] = (Button) findViewById(R.id.button14);

        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q=q+"0";
                et.setText(q);
                if (z == 0)
                    x =x*10 +0;
                if (z == 1)
                    y = y * 10 + 0;


                if (z == 2)
                    op();

            }
        });

        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q=q+"1";
                et.setText(q);
                if (z == 0)
                    x =x*10+1;
                if (z == 1)
                    y = y * 10 + 1;


                if (z == 2)
                    op();
            }
        });

        b[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q=q+"2";
                et.setText(q);
                if (z == 0)
                    x =x*10 +2;
                if (z == 1)
                y =y*10 +2;


                if (z == 2)
                    op();
            }
        });

        b[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q=q+"3";
                et.setText(q);
                if (z == 0)
                    x = x*10+3;
                if (z == 1)
                 y =y*10+3;


                if (z == 2)
                    op();
            }
        });

        b[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q=q+"4";
                et.setText(q);
                if (z == 0)
                    x =x*10+4;
                if (z == 1)
                    y = y*10 + 4;

                if (z == 2)
                    op();
            }
        });

        b[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q=q+"5";
                et.setText(q);
                if (z == 0)
                    x =x*10+5;
                if (z == 1)
                    y = y * 10 + 5;


                if (z == 2)
                    op();
            }
        });

        b[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q=q+"6";
                et.setText(q);
                if (z == 0)
                    x =x*10+6;
                if (z == 1)
                    y = y * 10 + 6;

                if (z == 2)
                    op();
            }
        });

        b[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q=q+"7";
                et.setText(q);
                if (z == 0)
                    x =x*10+7;
                if (z == 1)
                    y = y * 10 + 7;

                if (z == 2)
                    op();
            }
        });

        b[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q=q+"8";
                et.setText(q);
                if (z == 0)
                    x =x*10+8;
                if (z == 1)
                    y = y * 10 + 8;


                if (z == 2)
                    op();
            }
        });

        b[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q=q+"9";
                et.setText(q);
                if (z == 0)
                    x =x*10+9;
                if (z == 1)
                    y = y * 10 + 9;


                if (z == 2)
                    op();
            }
        });

        b[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText("");
                x = 0;
                y = 0;
                z = 0;
                o = "";
                q="";
            }
        });

        b[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                z++;
                if(z==2) {
                    op();
                    z = 1;
                }
                q = q + "+";
                o = "+";
                et.setText(q);
            }
        });

        b[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                z++;
                if(z==2) {
                    op();
                    z = 1;
                }
                q = q + "-";
                o = "-";
                et.setText(q);
            }
        });

        b[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                z++;
                if(z==2) {
                    op();
                    z = 1;
                }
                q = q + "*";
                o = "*";
                et.setText(q);
            }
        });

        b[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                z++;
                if(z==2) {
                    op();
                    z = 1;
                }
                q = q + "/";
                o = "/";
                et.setText(q);
            }
        });

        b[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op();
            }
        });

    }

    void op() {
        int k = 0;
        switch (o) {
            case ("+"):
                k = x + y;
                et.setText("" + k);
                break;

            case ("-"):
                k = x - y;
                et.setText("" + k);
                break;

            case ("*"):
                k = x * y;
                et.setText("" + k);
                break;

            case ("/"):
                try {
                    k = x / y;
                    et.setText("" + k);
                    break;
                }
                catch (Exception exc)
                {
                    Toast.makeText(MainActivity.this,"Infinity",Toast.LENGTH_SHORT).show();}
        }
        x = k;
        y = 0;
        z = 0;
        o = "";
        q="";
        q=q+k;

    }

}
