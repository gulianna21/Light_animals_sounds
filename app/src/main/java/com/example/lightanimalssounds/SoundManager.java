package com.example.lightanimalssounds;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.util.SparseIntArray;

public class SoundManager {
    private final SparseIntArray mSoundPoolMap;
    private final SoundPool mSoundPool;

    SoundManager(Context context){
        AudioAttributes attributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();
        mSoundPool = new SoundPool.Builder().setMaxStreams(5).
                setAudioAttributes(attributes).build();

        mSoundPoolMap = new SparseIntArray();
        mSoundPoolMap.put(0, mSoundPool.load(context, R.raw.cat1, 1));
        mSoundPoolMap.put(1, mSoundPool.load(context, R.raw.cat2, 1));
        mSoundPoolMap.put(2, mSoundPool.load(context, R.raw.cat3, 1));
        mSoundPoolMap.put(3, mSoundPool.load(context, R.raw.cat4, 1));
        mSoundPoolMap.put(4, mSoundPool.load(context, R.raw.cat5, 1));
        mSoundPoolMap.put(5, mSoundPool.load(context, R.raw.cat6, 1));
        mSoundPoolMap.put(6, mSoundPool.load(context, R.raw.lion, 1));
        mSoundPoolMap.put(7, mSoundPool.load(context, R.raw.lion2, 1));
        mSoundPoolMap.put(8, mSoundPool.load(context, R.raw.whale, 1));
        mSoundPoolMap.put(9, mSoundPool.load(context, R.raw.elephant, 1));
        mSoundPoolMap.put(10, mSoundPool.load(context, R.raw.horse, 1));
        mSoundPoolMap.put(11, mSoundPool.load(context, R.raw.dog, 1));
    }

    void play(int musicID){
        mSoundPool.play(mSoundPoolMap.get(musicID), 1, 1, 0, 0, 1);
    }
}
