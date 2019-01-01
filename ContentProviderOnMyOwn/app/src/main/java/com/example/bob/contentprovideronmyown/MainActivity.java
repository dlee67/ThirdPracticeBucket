package com.example.bob.contentprovideronmyown;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.bob.contentprovideronmyown.CoursesContract.get;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CoursesCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.term_list);
    }

    public void insertQuery(View view){
        CoursesHelper coursesHelper = new CoursesHelper(getApplicationContext());
        ContentValues values = new ContentValues();
        //A big mess is what _ID is.
        //https://stackoverflow.com/questions/34817574/using-sqlite-in-android-to-get-rowid
        //There is community accepted design pattern on how we should deal with the _id column.
        values.put(get._ID, "1");
        values.put(get.COLUMN_TERM, "Fall 2014");
        values.put(get.COLUMN_COURSE, "Computer Organization 2");
        values.put(get.COLUMN_FINAL_GRADE, "C+");

        Uri newUri = getContentResolver().insert(get.FINAL_GRADES_URI, values);
    }

    public void displayResult(View view){
        CoursesHelper helper = new CoursesHelper(this);
        Log.i("dhl", "_ID in string: " + get._ID);
        String[] projection =
        {
            get._ID,
            get.COLUMN_TERM,
            get.COLUMN_COURSE,
            get.COLUMN_FINAL_GRADE
        };
        Cursor cursor = getContentResolver()
            .query(
                get.FINAL_GRADES_URI,
                projection,
                null,
                null,
                null
            );
        adapter = new CoursesCursorAdapter(this, cursor);
        listView.setAdapter(adapter); // If you don't invoke setAdapter, nothing shows.
        //todoAdapter.changeCursor(todoCursor);
        //By invoking the changeCursor, I can change what's being displayed on the ListView.
        //try{
        //    while(cursor.moveToNext()){
        //        for(int index = 0; index < cursor.getColumnCount(); index++) {
        //            Log.i("dhl", cursor.getString(index));
        //        }
        //    }
        //} finally {
        //    cursor.close();
        //}
    }
}
