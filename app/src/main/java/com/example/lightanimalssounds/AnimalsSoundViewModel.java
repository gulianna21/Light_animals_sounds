package com.example.lightanimalssounds;

import android.app.Application;

import androidx.annotation.NonNull;

import java.util.Map;

public class AnimalsSoundViewModel extends SoundViewModel{

    public AnimalsSoundViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void fillSoundTypes(Map<String, Integer> soundTypes) {
        soundTypes.put(SOUND1, R.raw.lion);
        soundTypes.put(SOUND2, R.raw.lion2);
        soundTypes.put(SOUND3, R.raw.whale);
        soundTypes.put(SOUND4, R.raw.elephant);
        soundTypes.put(SOUND5, R.raw.horse);
        soundTypes.put(SOUND6, R.raw.dog);
    }
}
