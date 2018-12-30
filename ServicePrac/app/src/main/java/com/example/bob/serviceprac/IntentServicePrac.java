package com.example.bob.serviceprac;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class IntentServicePrac extends IntentService{
    public IntentServicePrac() {
        super("IntentServicePrac");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public IntentServicePrac(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i("dhl", "In the IntentService class.");
        for(int c = 0; c < 10; c++){
            try {
                Log.i("dhl", "Counting: " + c);
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.i("dhl", "Jobs finished.");
    }
}
