package com.example.lightanimalssounds;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class SoundViewModel extends AndroidViewModel {
    public static final String SOUND1 = "SOUND1";
    public static final String SOUND2 = "SOUND2";
    public static final String SOUND3 = "SOUND3";
    public static final String SOUND4 = "SOUND4";
    public static final String SOUND5 = "SOUND5";
    public static final String SOUND6 = "SOUND6";

    private final Map<String, Integer> soundTypes = new HashMap<>();
    private SoundManager soundManager;

    public SoundViewModel(@NonNull Application application) {
        super(application);
        if (application instanceof AnimalApp) {
            soundManager = ((AnimalApp) application).getSoundManager();
        }
        fillSoundTypes(soundTypes);
        loadSounds();
    }

    public void onPlaySound(String soundType) {
        if (soundManager != null) {
            soundManager.play(soundType);
        }
    }

    @Override
    protected void onCleared() {
        if (soundManager != null) {
            Set<String> keys = soundTypes.keySet();
            for (String key : keys) {
                soundManager.unloadSound(key);
            }
        }
    }

    protected abstract void fillSoundTypes(Map<String, Integer> soundTypes);

    @SuppressWarnings("ConstantConditions")
    private void loadSounds() {
        if (soundManager != null) {
            Set<String> keys = soundTypes.keySet();
            for (String key : keys) {
                soundManager.loadSound(key, soundTypes.get(key));
            }
        }
    }
}
