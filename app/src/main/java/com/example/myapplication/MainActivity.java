package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Songs> songs = new ArrayList<>();

    public SQLiteDatabase musicDB;
    int id;
    ListView lvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = 0;

        DBHelper helper = new DBHelper(this);
        musicDB = helper.getWritableDatabase();

        Cursor tunes = musicDB.rawQuery("SELECT * FROM songs", null);
        String[] playlist_fields = tunes.getColumnNames();

        for (int i = 0; i < playlist_fields.length; i++) {
            System.out.println(playlist_fields[i]);
        }


        Cursor cursor = musicDB.rawQuery("SELECT * FROM songs", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            songs.add(new Songs(id, cursor.getString(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3)));
            id ++;
            cursor.moveToNext();
        }
        cursor.close();

        lvMain = (ListView) findViewById(R.id.playlist_lw);
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                System.out.println(position);
            }

        });
        setAdapterView();
    }

    public void myAddButtonClick(View view) {
        TextView name = (TextView)findViewById(R.id.name_tw);
        TextView author = (TextView)findViewById(R.id.author_tw);
        TextView release = (TextView)findViewById(R.id.year_tw);
        TextView duration = (TextView)findViewById(R.id.duration_tw);

        String name_txt = name.getText().toString();
        String author_txt = (String) author.getText().toString();
        int release_txt = Integer.parseInt(release.getText().toString());
        int duration_txt = Integer.parseInt(duration.getText().toString());

        musicDB.execSQL("INSERT INTO songs VALUES ('" + name_txt + "', '" + author_txt + "', " + release_txt + ", " + duration_txt + " )");
        songs.add(new Songs(id, name_txt, author_txt, release_txt, duration_txt));
        id ++;


        setAdapterView();
    }


    public void setAdapterView() {
        System.out.println(songs.size());
        SongsAdapter songsAdapter = new SongsAdapter(this, songs);

        lvMain.setAdapter(songsAdapter);

    }

    public void sortByName(View view) {
        for (int i = songs.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (songs.get(j).name.compareTo(songs.get(j + 1).name) > 0) {
                    Songs tmp1 = songs.get(j);
                    Songs tmp2 = songs.get(j + 1);
                    songs.set(j, tmp2);
                    songs.set(j + 1, tmp1);
                }
            }
        }
        setAdapterView();
    }

    public void sortByAuthor(View view) {
        for (int i = songs.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (songs.get(j).author.compareTo(songs.get(j + 1).author) > 0) {
                    Songs tmp1 = songs.get(j);
                    Songs tmp2 = songs.get(j + 1);
                    songs.set(j, tmp2);
                    songs.set(j + 1, tmp1);
                }
            }
        }
        setAdapterView();
    }
}