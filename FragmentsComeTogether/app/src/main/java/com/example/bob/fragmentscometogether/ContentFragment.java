package com.example.bob.fragmentscometogether;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.mainfrag, container, false);
        result.findViewById(R.id.showOther).setOnClickListener();
        return(result);
    }

    @Override
    public void onClick(View v) {
        ((StaticFragmentsDemoActivity)getActivity()).showOther(v);
    }
}
