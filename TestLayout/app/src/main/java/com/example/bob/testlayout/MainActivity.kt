package com.example.bob.testlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

//https://stackoverflow.com/questions/23149981/fragments-the-specified-child-already-has-a-parent-you-must-call-removeview
//Fixed the mentioned problem via above link.
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(R.id.frag_container_one, FragOne(), "frag_one")
                .add(R.id.frag_container_two, FragTwo(), "frag_two")
                .commit()
    }
}