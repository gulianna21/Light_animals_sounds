package com.example.lightanimalssounds;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;

import java.util.HashMap;

public class SoundManager {
    private final HashMap<String, Integer> mSoundPoolMap;
    private final SoundPool mSoundPool;

    Context context;

    SoundManager(Context context) {
        AudioAttributes attributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();
        mSoundPool = new SoundPool.Builder().setMaxStreams(1).
                setAudioAttributes(attributes).build();

        this.context = context;

        mSoundPoolMap = new HashMap<>();
    }

    void loadSound(String soundType, int soundID) {
        if (!mSoundPoolMap.containsKey(soundType)) {
            mSoundPoolMap.put(soundType, mSoundPool.load(context, soundID, 1));
        }
    }

    void unloadSound(String soundType) {
        Integer soundID = mSoundPoolMap.remove(soundType);
        if (soundID != null) {
            mSoundPool.stop(soundID);
            mSoundPool.unload(soundID);
        }
    }

    void play(String soundType) {
        Integer soundID = mSoundPoolMap.get(soundType);
        if (soundID != null) {
            mSoundPool.play(soundID, 1, 1, 0, 0, 1);
        }
    }
}
