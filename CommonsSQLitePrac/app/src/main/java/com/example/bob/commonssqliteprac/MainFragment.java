package com.example.bob.commonssqliteprac;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){

        //getActivity().getApplicationContext().deleteDatabase("stuff.db");
        //
        //DatabaseHelper db;
        //db = new DatabaseHelper(getActivity());
        //db.close();

        View mainView = inflater.inflate(R.layout.fragment_one, null);
        return mainView;
    }

}
