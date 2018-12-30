package com.example.bob.parcelablesprac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wow, that's pretty darn neat!
        Intent toSecond = new Intent(getApplicationContext(), SecondActivity.class);
        toSecond.putExtra("student", new Student(1,"Mike","6"));
        startActivity(toSecond);
    }
}
