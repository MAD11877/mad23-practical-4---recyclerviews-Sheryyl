package com.example.mad_wk4prac;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context c) {super (c, "userDB.db", null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE User (Name TEXT, Description TEXT, Id INT, Followed BOOLEAN)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS Message");
        onCreate(db);
    }

    public void addUser(User u)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO User VALUES( \"" + u.name + "\", \"" + u.description + "\", + \"" + u.id + "\", + \"" + u.followed + "\")");
        db.close();
    }

    public ArrayList<User> getUsers()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<User> list = new ArrayList<User>();

        Cursor cursor = db.rawQuery("SELECT * FROM USER", null);
        while(cursor.moveToNext())
        {
            User newUser = new User();
            newUser.name = cursor.getString(0);
            newUser.description = cursor.getString(1);
            newUser.id = cursor.getInt(2);
            newUser.followed = Boolean.parseBoolean(cursor.getString(3));
            list.add(newUser);
        }

        return list;
    }

    public void updateUser(User u)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE User SET Followed = \""+ u.followed +"\" " +  "WHERE id = \""+ u.id +"\"");
        db.close();
    }

    public int Count()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User", null);
        return cursor.getCount();       //Returns no. of rows
    }
}

