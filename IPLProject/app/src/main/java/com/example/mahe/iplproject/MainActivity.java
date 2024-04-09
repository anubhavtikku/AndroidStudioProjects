package com.example.mahe.iplproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b_default,b_teams,b_ins,b_season,b_players,b_fame,b_del,b_upd,b_cred;
    public static SQLiteDatabase sqLiteDatabase;
    Spinner spinner;
    String[] city={"Choose a team","Royal Challengers Bangalore","Sunrisers Hyderabad","Chennai Super Kings","Mumbai Indians","Kings XI Punjab","Rajasthan Royals","Kolkata Knight Riders","Delhi Daredevils"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_default = findViewById(R.id.button);
        b_teams = findViewById(R.id.button3);
        b_ins=findViewById(R.id.button2);
        b_season=findViewById(R.id.button6);
        b_players=findViewById(R.id.button7);
        b_fame=findViewById(R.id.button8);
        b_del=findViewById(R.id.button9);
        b_upd=findViewById(R.id.button10);
        b_cred=findViewById(R.id.button14);
        spinner=findViewById(R.id.spinner);
        ArrayAdapter<String> spinadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,city);
        spinner.setAdapter(spinadapter);

        sqLiteDatabase = openOrCreateDatabase("DBName", MODE_PRIVATE, null);
        if (sqLiteDatabase != null) {



            tablecreate();

            b_default.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    playerins();
                    Toast.makeText(MainActivity.this, "Database set to default", Toast.LENGTH_SHORT).show();

                }
            });

            b_ins.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(i);

                }
            });

            b_del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(MainActivity.this,ThirdActivity.class);
                    startActivity(i);
                }
            });

            b_cred.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(MainActivity.this,CredActivity.class);
                    startActivity(i);
                }
            });

            b_upd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(MainActivity.this,FourthActivity.class);
                    startActivity(i);
                }
            });

            b_season.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fetchseasons();
                }
            });

            b_players.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fetchpl();
                }
            });

            b_teams.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  fetchdataofteams();
                }
            });

           b_fame.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   fame();
               }
           });

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String q;
                    switch(position) {
                        case 1:
                            q = "Royal Challengers Bangalore";
                            plofteams(q);
                            break;

                        case 2:
                            q = "Sunrisers Hyderabad";
                            plofteams(q);
                            break;

                        case 3:
                            q = "Chennai Super Kings";
                            plofteams(q);
                            break;

                        case 4:
                            q = "Mumbai Indians";
                            plofteams(q);
                            break;

                        case 5:
                            q = "Kings XI Punjab";
                            plofteams(q);
                            break;

                        case 6:
                            q = "Rajasthan Royals";
                            plofteams(q);
                            break;

                        case 7:
                            q = "Kolkata Knight Riders";
                            plofteams(q);
                            break;

                        case 8:
                            q = "Delhi Daredevils";
                            plofteams(q);
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }

    }

    private void playerins() {
        String query="delete from Players ";
        sqLiteDatabase.execSQL(query);


        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(1,'MS DHONI','Wk-Batsman','IND','Chennai Super Kings')";
        sqLiteDatabase.execSQL(query);


        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(2,'VIRAT KOHLI','Batsman','IND','Royal Challengers Bangalore')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(3,'SURESH RAINA','Batsman','IND','Chennai Super Kings')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(4,'ROHIT SHARMA','Batsman','IND','Mumbai Indians')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(5,'SHIKHAR DHAWAN','Batsman','IND','Sunrisers Hyderabad')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(6,'GAUTAM GAMBHIR','Batsman','IND','Kolkata Knight Riders')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(7,'MANISH PANDEY','Batsman','IND','Kolkata Knight Riders')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(8,'KEDHAR JADHAV','Batsman','IND','Royal Challengers Bangalore')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(9,'AJINKYA RAHANE','Batsman','IND','Rajasthan Royals')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(10,'DINESH KARTHIK','Wk-Batsman','IND','Delhi Daredevils')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(11,'KL RAHUL','Wk-Batsman','IND','Royal Challengers Bangalore')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(12,'MURALI VIJAY','Batsman','IND','Kings XI Punjab')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(13,'KANE WILLAIMSON','Batsman','NZ','Sunrisers Hyderabad')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(14,'BRENDON McCULLUM','Wk-Batsman','NZ','Chennai Super Kings')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(15,'CHRIS GAYLE','Batsman','WI','Royal Challengers Bangalore')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(16,'STEVE SMITH','Batsman','AUS','Rajasthan Royals')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(17,'DAVID WARNER','Batsman','AUS','Sunrisers Hyderabad')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into Players(PId,PName,Role,Country,Tname) values(18,'AARON FINCH','Batsman','AUS','Mumbai Indians')";
        sqLiteDatabase.execSQL(query);
    }



    void tablecreate()
    { String query="create table if not exists Team (TId number primary key,TName varchar(32) unique, MatPlay number)";
        sqLiteDatabase.execSQL(query);




         query="Create table if not exists  Players (PId number(3,0) primary key,PName varchar(20) not null,Role varchar(15) not null,Country char(3) not null,Tname varchar(32),foreign key(Tname) REFERENCES Team ON  DELETE cascade)";

        sqLiteDatabase.execSQL(query);


        query="create table if not exists season (year number primary key,TName varchar(10),foreign key(TName) references Team ON  update cascade)";

        sqLiteDatabase.execSQL(query);

        query="create table if not exists fame (year number primary key,PName varchar(20),TName varchar(32),foreign key(TName) references Team ON  update cascade)";

        sqLiteDatabase.execSQL(query);

        query="insert or replace into fame values (2008,'Shane Watson','Rajasthan Royals')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into fame values (2009,' Adam Gilchrist','Sunrisers Hyderabad')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into fame values (2010,'Sachin Tendulkar','Mumbai Indians')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into fame values (2011,'Chris Gayle','Royal Challengers Bangalore')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into fame values (2012,'Sunil Narine','Kolkata Knight Riders')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into fame values (2013,'Shane Watson','Rajasthan Royals')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into fame values (2014,'Glenn Maxwell ','Kings XI Punjab')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into fame values (2015,'Andre Russell','Kolkata Knight Riders')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into fame values (2016,'Virat Kohli','Royal Challengers Bangalore')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into fame values (2017,'Ben Stokes','Chennai Super Kings')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into season values (2008,'Rajasthan Royals')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into season values (2009,'Sunrisers Hyderabad')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into season values (2010,'Chennai Super Kings')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into season values (2011,'Chennai Super Kings')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into season values (2012,'Kolkata Knight Riders')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into season values (2013,'Mumbai Indians')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into season values (2014,'Kolkata Knight Riders')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into season values (2015,'Mumbai Indians')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into season values (2016,'Sunrisers Hyderabad')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into season values (2017,'Mumbai Indians')";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into team values (1,'Chennai Super Kings',97)";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into team values (2,'Royal Challengers Bangalore',120)";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into team values (3,'Mumbai Indians',120)";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into team values (4,'Kolkata Knight Riders',120)";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into team values (5,'Kings XI Punjab',120)";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into team values (6,'Delhi Daredevils',120)";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into team values (7,'Rajasthan Royals',120)";
        sqLiteDatabase.execSQL(query);

        query="insert or replace into team values (8,'Sunrisers Hyderabad',120)";
        sqLiteDatabase.execSQL(query);
    }

    void fetchdataofteams()
    {
        String query="select tid,tname from team";
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        String s="ID\t\tName\n\n";
        String m="Teams Details";
        while (cursor.moveToNext())
        {
            String tid=cursor.getString(0);
            String tname=cursor.getString(1);
            s=s+tid+"\t\t"+tname+"\n\n";
        }
        cursor.close();
        alertMag(s,m);
    }

    void alertMag(String msg,String m)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(m);
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setMessage(msg);
        builder.create();
        builder.show();
    }

    void plofteams(String q)
    {
        String query="select pname,role from players where tname='"+q+"'";
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        String s="Name\t\tRole\n\n";
        String m="Players of the team";
        while (cursor.moveToNext())
        {
            String tid=cursor.getString(0);
            String tname=cursor.getString(1);
            s=s+tid+"\t\t"+tname+"\n\n";
        }
        cursor.close();
        alertMag(s,m);
    }

    void fetchpl()
    {
        String query="select * from players ";
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        String s="ID\t\tName\t\tRole\t\tCountry\t\tTeam\n\n";
        String m="Players";
        while (cursor.moveToNext())
        {
            String tid=cursor.getString(0);
            String tname=cursor.getString(1);
            String role=cursor.getString(2);
            String country=cursor.getString(3);
            String team=cursor.getString(4);
            s=s+tid+"\t\t"+tname+"\t\t"+role+"\t\t"+country+"\t\t"+team+"\n\n\n";
        }
        cursor.close();
        alertMag(s,m);
    }

    void fetchseasons()
    {
        String query="select year,tname from season ";
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        String s="Year\t\tChampions\n\n";
        String m="IPL Seasons";
        while (cursor.moveToNext())
        {
            String tid=cursor.getString(0);
            String tname=cursor.getString(1);
            s=s+tid+"\t\t"+tname+"\n\n";
        }
        cursor.close();
        alertMag(s,m);
    }

    void fame()
    {
        String query="select year,pname,tname from fame ";
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        String s="Year\t\tPlayer\t\tTeam\n\n\n";
        String m="IPL Player of the Season";
        while (cursor.moveToNext())
        {
            String tid=cursor.getString(0);
            String tname=cursor.getString(1);
            String tename=cursor.getString(2);
            s=s+tid+"\t\t"+tname+"\t\t"+tename+"\n\n\n";
        }
        cursor.close();
        alertMag(s,m);
    }

}
