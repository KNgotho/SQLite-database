package com.example.notekeeper;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class EndClass extends AppCompatActivity {

    TextView emview, idview;

    NoteKeeperOpenHelper dbHelper;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        emview= findViewById(R.id.out_email);
        idview = findViewById(R.id.out_id);

        dbHelper = new NoteKeeperOpenHelper(this);
        db = dbHelper .getReadableDatabase();

        //Retrieve data in the cursor and display the data in a TextView

       Cursor res = dbHelper.getInfo();
       int count = res.getCount();
       if (count>0)
           for(res.moveToFirst(); !res.isAfterLast(); res.moveToNext()) {
               String email = res.getString(res.getColumnIndex(NoteKeeperContractClass.UsersEntry.EMAIL_ADDRESS));
               String id = String.valueOf(res.getInt(res.getColumnIndex(NoteKeeperContractClass.UsersEntry.ID_NUMBER)));

               emview.setText(email);
               idview.setText(id);
           }
       else {
           String email = "Empty";
           int id = 0;
           emview.setText(email);
           idview.setText(id);

       }
res.close();

    }
    // CLose the database and application after pressing the button close
    public void closeDB(View view){
        dbHelper.close();
        db.close();
        finishAffinity();
    }

}
