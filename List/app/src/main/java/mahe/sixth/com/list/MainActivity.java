package mahe.sixth.com.list;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    String []places={"Taj Mahal","Himalayas","Red Fort","India Gate"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter adapter;
        adapter=new ArrayAdapter<>(this,R.layout.linlayout,R.id.textView2,places);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this,"You selected "+l.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
    }
}
