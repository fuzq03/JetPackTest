package com.example.jetpacktest;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void Create() {
        Log.d("Observer", "Create");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void Start() {
        Log.d("Observer", "Start");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void Resume() {
        Log.d("Observer", "Start");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void Pause() {
        Log.d("Observer", "Start");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void Stop() {
        Log.d("Observer", "Stop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void Destroy() {
        Log.d("Observer", "Start");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void Any() {
        Log.d("Observer", "ANY");
    }

    public MyObserver(Lifecycle lifecycle) {
    }
}
