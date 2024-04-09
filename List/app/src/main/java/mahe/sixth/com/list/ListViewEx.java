package mahe.sixth.com.list;

import android.app.ListActivity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class ListViewEx extends ListActivity{
    ListView lv;
    Spinner spinner;
    RelativeLayout rl;
    AutoCompleteTextView tv;
    String[] city={"Delhi","Mumbai","Agra","Lucknow"};

    String[] words={"Cat","Dog","Camel","Cow"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_ex);
        lv=(ListView) findViewById(R.id.ld);
        spinner=(Spinner)findViewById(R.id.spinner);
        rl=(RelativeLayout)findViewById(R.id.rl);
        tv=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> spinadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,city);
        spinner.setAdapter(spinadapter);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city);
        lv.setAdapter(adapter);
        ArrayAdapter<String> wordadapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,words);
        tv.setThreshold(2);
        tv.setAdapter(wordadapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewEx.this, "" + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        Toast.makeText(ListViewEx.this, "Great Delhi", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(ListViewEx.this, "Great Mumbai", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0:
                        rl.setBackgroundColor(Color.RED);
                        break;

                    case 1:
                        rl.setBackgroundColor(Color.GREEN);
                        break;

                    case 2:
                        rl.setBackgroundColor(Color.CYAN);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
