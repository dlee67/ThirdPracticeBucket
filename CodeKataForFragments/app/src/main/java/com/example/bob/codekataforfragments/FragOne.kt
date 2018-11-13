package com.example.bob.codekataforfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragOne: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Previously,
        // inflater.inflate(R.layout.fragment_one, container) was what I had,
        // I should go find out why the below is working, but the above is not.

        // https://stackoverflow.com/questions/12567578/what-does-the-layoutinflater-attachtoroot-parameter-mean
        // The above explains it in a very straight forward way.

        // When you set it to, you are pretty much telling the Android to attach the View to the
        // parent right now.
        return inflater.inflate(R.layout.fragment_one, container, false)
    }
}