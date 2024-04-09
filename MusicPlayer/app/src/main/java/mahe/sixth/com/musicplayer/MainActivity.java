package mahe.sixth.com.musicplayer;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.lv);
        final ArrayList<File> mysongs=findSongs(Environment.getExternalStorageDirectory());
        items=new String[mysongs.size()];
        for(int i=0;i<mysongs.size();i++)
        {
            toast(mysongs.get(i).getName().toString());
            items[i]=mysongs.get(i).getName().toString();
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,Player.class);
                intent.putExtra("pos",i);
                intent.putExtra("songlist",mysongs);
                startActivity(intent);
            }
        });
    }

    public ArrayList<File> findSongs(File file)
    { ArrayList<File> a1=new ArrayList<File>();
      File[] files=file.listFiles();
      for(File singleFiles:files)
      {
          if(singleFiles.isDirectory() && !singleFiles.isHidden())
          {
              a1.addAll(findSongs(singleFiles));
          }

          else
          {
              if(singleFiles.getName().endsWith(".mp3"))
              {
                  a1.add(singleFiles);
              }
          }

      }

      return  a1;
    }

    public  void  toast(String text)
    {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
