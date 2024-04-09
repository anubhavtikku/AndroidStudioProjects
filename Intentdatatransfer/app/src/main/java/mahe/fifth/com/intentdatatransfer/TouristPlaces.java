package mahe.fifth.com.intentdatatransfer;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class TouristPlaces extends ListActivity {

    String []places={"Taj Mahal","Himalayas","Red Fort","India Gate"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setContentView(R.layout.activity_tourist_places);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,places);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this,"You selected "+l.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
        switch (position)
        {
            case 0:
                Intent i=new Intent(TouristPlaces.this,TajMahal.class);
                startActivity(i);
                break;

            case 1:
                Intent i1=new Intent(TouristPlaces.this,Himalayas.class);
                startActivity(i1);
                break;

            case 2:
                Intent i2=new Intent(TouristPlaces.this,RedFort.class);
                startActivity(i2);
                break;

            case 3:
                Intent i3=new Intent(TouristPlaces.this,IndiaGate.class);
                startActivity(i3);
                break;

        }
    }
}
