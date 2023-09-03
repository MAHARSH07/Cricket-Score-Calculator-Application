package com.example.madproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {

    //To create database
    public DatabaseHelper( Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, version);
    }
    //Creating table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table first_innings(teamname varchar(50),score int,wickets int)");

    }

    //drop table when version changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists first_innings");

        onCreate(db);
    }

    //to save user data

    public long saveUserData(String teamname,int score,int wickets)
    {
        SQLiteDatabase db=this.getWritableDatabase();//For storing data
        ContentValues cv=new ContentValues();
        cv.put("teamname",teamname);
        cv.put("score",score);
        cv.put("wickets",wickets);
        long recordId=db.insert("first_innings",null,cv);
        return recordId;
    }



    public String getAllRecords()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from first_innings",null);
        String output="";
        while(cursor.moveToNext())
        {
            String teamname=cursor.getString(0);
            int score=cursor.getInt(1);
            int wickets=cursor.getInt(2);
            //output=output+teamname+"-"+score+"-"+wickets+"\n";
            output=teamname;
        }
        return output;
    }



    public void deleteAllRecords() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("first_innings", null, null);
        db.close();
    }
    public Cursor getAllData() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query("first_innings", null, null, null, null, null, null);
    }

    public void deleteAllRows() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("first_innings", null, null);
        db.close();
    }



}
