package com.example.lightanimalssounds;

import android.app.Application;

public class AnimalApp extends Application {

    public SoundManager soundManager;

    @Override
    public void onCreate() {
        super.onCreate();
        soundManager = new SoundManager(this);
    }

    public SoundManager getSoundManager() {
        return soundManager;
    }
}
