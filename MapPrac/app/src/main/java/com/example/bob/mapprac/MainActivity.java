package com.example.bob.mapprac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

/*
    In the world of Android, there are these things called API key,
    which is a meta-data for Google's service to how you should be billed.
*/
public class MainActivity extends AppCompatActivity {

    final LatLng position = new LatLng(21, 57);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
