package com.example.bob.sqlitecodekata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_one_container, new FragOne(), "FragOne")
                .add(R.id.fragment_two_container, new FragTwo(), "FragTwo")
                .commit();
    }
}
