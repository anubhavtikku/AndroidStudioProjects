package mahe.sixth.com.menu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b_pop,b_context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_pop=(Button)findViewById(R.id.button);
        b_context=(Button)findViewById(R.id.button2);
        b_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,b_pop);
                getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(MainActivity.this, "You clicked ", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        registerForContextMenu(b_context);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item1:
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+917583802099"));
                startActivity(i);
                break;

            case R.id.action_settings:
                Intent i1=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.fb.com"));
                startActivity(i1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,v.getId(),0,"Call");
        menu.add(0,v.getId(),0,"Facebook");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getTitle() =="Call")
        {
            Toast.makeText(this, "Calling from context ", Toast.LENGTH_SHORT).show();
        }
        else if (item.getTitle() =="Facebook")
        {
            Toast.makeText(this, " Facebook Context ", Toast.LENGTH_SHORT).show();
        }

        else
            return false;

        return true;
    }
}
