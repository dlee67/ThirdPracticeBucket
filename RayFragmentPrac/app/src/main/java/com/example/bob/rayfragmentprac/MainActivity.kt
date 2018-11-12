package com.example.bob.rayfragmentprac

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View

class MainActivity : AppCompatActivity() {

    lateinit var fragOne: Fragment
    lateinit var fragTwo: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragOne = FragmentOne()
        fragTwo = FragmentTwo()

        // beginTransaction() returns FragmentTransaction object, so does add().
        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_one_container, fragOne, "frag_one")
                .commit()
    }

    // My click of a button, I can swap out an entire layout.
    fun changeMeme(view: View){
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_one_container, fragTwo, "frag_two")
                .commit()
    }

    // A way to save data when orientation changes.
    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
    }
}
