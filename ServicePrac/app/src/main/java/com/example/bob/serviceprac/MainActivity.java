package com.example.bob.serviceprac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


/*
    <!-- Android reads an application's manifest when it's installed,           -->
    <!-- which registers the identifers of necessary components (like, Service) -->
    <!-- to the application table. -->
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent starter = new Intent(getApplicationContext(), IntentServicePrac.class);
        startService(starter);
    }
}
