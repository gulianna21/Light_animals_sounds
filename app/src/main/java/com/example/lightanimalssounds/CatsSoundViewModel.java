package com.example.lightanimalssounds;

import android.app.Application;

import androidx.annotation.NonNull;

import java.util.Map;

public class CatsSoundViewModel extends SoundViewModel{

    public CatsSoundViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void fillSoundTypes(Map<String, Integer> soundTypes) {
        soundTypes.put(SOUND1, R.raw.cat1);
        soundTypes.put(SOUND2, R.raw.cat2);
        soundTypes.put(SOUND3, R.raw.cat3);
        soundTypes.put(SOUND4, R.raw.cat4);
        soundTypes.put(SOUND5, R.raw.cat5);
        soundTypes.put(SOUND6, R.raw.cat6);
    }
}
