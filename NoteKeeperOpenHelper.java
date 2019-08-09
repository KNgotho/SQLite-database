package com.example.notekeeper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class NoteKeeperOpenHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 2;
    public static final String DB_NAME = "NoteKeeper";
    //Initialize table using SQLiteopenhelper
    public NoteKeeperOpenHelper (Context context){
        super (context, DB_NAME, null, DB_VERSION);
    }
    //Create database db using SQL
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(NoteKeeperContractClass.UsersEntry.SQL_CREATE_TABLES);

        }
     //   Upgrade database
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(NoteKeeperContractClass.UsersEntry.SQL_DELETE_TABLES);
        onCreate(db);

    }// Query database to output data
    public Cursor getInfo(){
        String [] cols = {NoteKeeperContractClass.UsersEntry.EMAIL_ADDRESS,NoteKeeperContractClass.UsersEntry.ID_NUMBER};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.query(NoteKeeperContractClass.UsersEntry.SQL_QUERY_TABLE,cols, null,null,null,null,null);
        return res;
    }



}
