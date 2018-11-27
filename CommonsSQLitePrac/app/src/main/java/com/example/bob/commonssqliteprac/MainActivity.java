package com.example.bob.commonssqliteprac;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Wow, the below is actually pretty neat.
        //The below has a lot of potential to decrease a complexity.
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_activity, new MainFragment(), "MainFragment")
                .commit();
        db = new DatabaseHelper(getApplicationContext());
        db.close();
    }
}
