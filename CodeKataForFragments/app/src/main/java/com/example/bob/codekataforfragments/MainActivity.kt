package com.example.bob.codekataforfragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragOne = FragOne()
        var fragTwo = FragTwo()

        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_one, fragOne)
                .add(R.id.fragment_container_two, fragTwo)
                .commit()
    }
}
