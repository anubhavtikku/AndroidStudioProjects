package mahe.third.com.design;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button bt_show,bt_save;
    EditText et_user,et_file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_save=(Button)findViewById(R.id.button);
        bt_show=(Button)findViewById(R.id.button2);
        et_user=(EditText)findViewById(R.id.editText);
        et_file=(EditText)findViewById(R.id.editText2);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName=et_file.getText().toString();
                try {
                    FileOutputStream fout = openFileOutput(fileName + ".txt", MODE_PRIVATE);
                    String text=et_user.getText().toString();
                    byte[] data= text.getBytes();
                    fout.write(data);
                    fout.flush();
                    fout.close();
                    Toast.makeText(MainActivity.this, "Data is written ", Toast.LENGTH_SHORT).show();
                    et_user.setText("");
                    et_file.setText("");
                }
                catch (FileNotFoundException exc)
                {
                    Toast.makeText(MainActivity.this, "File not found ", Toast.LENGTH_SHORT).show();
                    exc.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "IO Exception ", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bt_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int count=0;
                    String text="";
                    String filename = et_file.getText().toString();
                    FileInputStream fin = openFileInput(filename + ".txt");
                    while ((count=fin.read())!=-1)
                    {
                        text=text+(char)count;
                    }

                    et_user.setText(text);

                }
                catch (FileNotFoundException e)
                { e.printStackTrace();
                    Toast.makeText(MainActivity.this, "File not found ", Toast.LENGTH_SHORT).show();
                }

                catch (IOException e) {
                    Toast.makeText(MainActivity.this, "IO Exception ", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });

    }
}
