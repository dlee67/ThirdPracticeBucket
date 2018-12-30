package com.example.bob.parcelablesprac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Bundle data = getIntent().getExtras();
        Student student = (Student) data.getParcelable("student");
        Log.i("dhl", "Hi, " + student.getName());
    }
}
