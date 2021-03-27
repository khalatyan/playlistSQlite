package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "playlist.db";
    final static String TABLE_NAME = "songs";
    final static String CREATE = "CREATE TABLE "+TABLE_NAME+ "(`name` TEXT NOT NULL, `author` TEXT NOT NULL, `duration` INTEGER NOT NULL, `release` INTEGER NOT NULL )";
    // при изменении структуры БД меняется и версия
    private static final int DATABASE_VERSION = 10;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // выполняется, если базы данных нет
        db.execSQL(CREATE);
//        db.execSQL("INSERT INTO songs VALUES ('Storm', 'U2', 1998, 300 )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // выполняется, если версия базы данных отличается
        db.execSQL("DROP TABLE "+ TABLE_NAME);
        this.onCreate(db);
    }
}