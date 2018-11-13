package com.example.bob.morecodekataforfragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_one, FragOne())
                .add(R.id.fragment_container_two, FragTwo())
                .commit()
    }
}
