package com.example.bob.androidconcurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class MyHandler extends Handler {

    //By doing the below, we are associating the passed in looper with the handler.
    public MyHandler(Looper looper){
        super(looper);
    }

    @Override
    public void handleMessage(Message msg){ // Invoked by the Looper
        // This is where the messages are handled.
        Log.i("dhl", String.valueOf(msg.getData().getCharSequence("RainyDay")));
    }
}
