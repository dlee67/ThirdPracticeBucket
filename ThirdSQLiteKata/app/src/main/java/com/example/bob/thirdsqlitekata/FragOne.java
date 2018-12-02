package com.example.bob.thirdsqlitekata;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragOne extends Fragment {

    String TITLE="title";
    String VALUE="value";
    String TABLE="constants";
    DBHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DBHelper(getActivity().getApplicationContext(), "MoarStuff.db");
        insertStuff();
        readStuff();
    }

    @Override
    public View onCreateView (LayoutInflater inflater,
                       ViewGroup container,
                       Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    public void insertStuff(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TITLE, "Gravity, Death Start I");
        cv.put(VALUE, SensorManager.GRAVITY_DEATH_STAR_I);
        db.insert(TABLE, TITLE, cv);
    }

    public void readStuff(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM constants;", null);
        for(int index = 0; result.moveToNext(); index++){
            int id=result.getInt(index);
            String name=result.getString(index);
            int inventory=result.getInt(index);
            Log.i("dhl", "id is: " + id);
            Log.i("dhl", "name is: " + name);
            Log.i("dhl", "inventory is: " + inventory);
        }
        result.close();
    }
}