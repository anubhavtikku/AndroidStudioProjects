package mahe.fifth.com.placestovisit;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    String[] places = {"Taj Mahal", "Himalayas", "RedFort"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, places);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {
            case 0:
                Intent i = new Intent(MainActivity.this, Taj.class);
                startActivity(i);
                break;

            case 1:
                Intent i1 = new Intent(MainActivity.this, Himalaya.class);
                startActivity(i1);
                break;

            case 2:
                Intent i2 = new Intent(MainActivity.this, Red.class);
                startActivity(i2);
                break;
        }
    }
}