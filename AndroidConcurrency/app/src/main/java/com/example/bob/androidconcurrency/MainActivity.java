package com.example.bob.androidconcurrency;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SimpleLooper simpleLooper;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleLooper = new SimpleLooper();
        simpleLooper.start();
        //simpleLooper.waitForStart();

        //The below is invalid.
        //Handler handler = new MyHandler(simpleLooper);
        //Loopers are associated with the Thread via on a system level,
        //where each Threads in Android has Looper attached to'em.

        handler = new MyHandler(simpleLooper.getLooper());
        //Message msg = handler.obtainMessage(); // Returns a message from global message pool.
    }

    public void shootMsg(View view){
        Message msg = new Message();
        Bundle msgBundle = new Bundle();
        msgBundle.putCharSequence("RainyDay", "On a silent way.");
        msg.setData(msgBundle);
        //Messages are not directly associated with the MessageQueue, but through a Handler.
        handler.sendMessage(msg);
        //After adding below two lines, the message stopped showing in the Handler.
        //Log.i("dhl", "Qutting looper.");
        //simpleLooper.getLooper().quit();
    }
}
