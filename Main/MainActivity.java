package com.example.notekeeper;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    NoteKeeperOpenHelper dbHelper;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call an instance of NoteKeeperOpenhelper to manage database
        dbHelper = new NoteKeeperOpenHelper(this);
        //Instantiate a writable database db
        db = dbHelper.getWritableDatabase();


    }
    //Onlick ethod for button senddata
    public void sendMessage (View view){

            insertData();
            Intent i = new Intent(MainActivity.this, EndClass.class);
            startActivity(i);
        }
// Methos to insert data in initialized database db
    private boolean insertData (){

            EditText emailt = findViewById(R.id.emailed);
            EditText idnumbert = findViewById(R.id.idnumber);
            String EmailAddress = emailt.getText().toString();
            int IDNumber = Integer.parseInt(idnumbert.getText().toString());

            ContentValues content = new ContentValues();
            content.put(NoteKeeperContractClass.UsersEntry.EMAIL_ADDRESS, EmailAddress);
            content.put(NoteKeeperContractClass.UsersEntry.ID_NUMBER, IDNumber);
            db.insert(NoteKeeperContractClass.UsersEntry.TABLE_NAME, null, content);

            return true;
    }

   // public void finalize() throws Throwable{
      //  if(null != dbHelper )
            //dbHelper.close();
     //   if(null != db)
           // db.close();
     //   super.finalize();

    //}


    }

