package com.example.notekeeper;

import android.provider.BaseColumns;

public final class NoteKeeperContractClass {
    // Method to define table in the Database
    public static class UsersEntry implements BaseColumns {
        public static String TABLE_NAME = "Users";
        public static final String EMAIL_ADDRESS = "EmailAddress";
        public static final String ID_NUMBER = "IDNumber";
        //Method to create table
        public static final String SQL_CREATE_TABLES =
                "CREATE TABLE " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY," + EMAIL_ADDRESS + " TEXT," + ID_NUMBER + " INT)";
        //Method to delete table
        public static final String SQL_DELETE_TABLES = "DROP TABLE IF EXISTS " + TABLE_NAME;
        //Method to query table
        public static final String SQL_QUERY_TABLE =  TABLE_NAME;

    }
}
