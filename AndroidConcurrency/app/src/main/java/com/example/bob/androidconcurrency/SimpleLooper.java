package com.example.bob.androidconcurrency;

import android.os.Handler;
import android.os.Looper;

public class SimpleLooper extends Thread{

    // Handler provides an interface to submit messages to its Looper,
    // and implementing the callback for processing those messages when they
    // are dispatched by the Looper.
    public Handler mHandler;
    boolean started = false;
    Object startMonitor = new Object();
    Looper threadLooper = Looper.myLooper();

    //java.Thread, by default, does not have a looper associated with them; therefore,
    public void run(){
        Looper.prepare(); // to create one, we call prepare() to create the Looper.
                          // The prepare() is also responsible for creating the MessageQueue.
                          // At the same time, prepare() blocks the run(), until it is interrupted with a Message.
        //threadLooper = Looper.myLooper(); // myLooper returns the Looper object associated with the current thread.
        //synchronized (startMonitor){
        //    started = true;
        //    startMonitor.notifyAll(); // Wakes up all Threads those are waiting on this monitor.
        //}
        Looper.loop(); // and loop() to create the Handler. This is how Looper waits for Message.
        // To stop the looper, we can call quit() or quitSafely().
    }

    //public void waitForStart(){
    //    synchronized (startMonitor){
    //        while(!started){
    //            try{
    //                startMonitor.wait(10);
    //            } catch(InterruptedException e) {
    //
    //            }
    //        }
    //    }
    //}

    public Looper getLooper(){
        return threadLooper;
    }

    public Handler getHandler(){
        return mHandler;
    }
}