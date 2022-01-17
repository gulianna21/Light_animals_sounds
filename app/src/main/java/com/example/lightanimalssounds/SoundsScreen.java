package com.example.lightanimalssounds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SoundsScreen extends AppCompatActivity {
    public static final String ANIMAL = "Animal";
    private int startInd = 0;

    TextView animal;
    Button play1;
    Button play2;
    Button play3;
    Button play4;
    Button play5;
    Button play6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds_screen);

        animal = findViewById(R.id.animal);
        play1 = findViewById(R.id.sound1);
        play2 = findViewById(R.id.sound2);
        play3 = findViewById(R.id.sound3);
        play4 = findViewById(R.id.sound4);
        play5 = findViewById(R.id.sound5);
        play6 = findViewById(R.id.sound6);

        Bundle data = getIntent().getExtras();
        animal.setText(data.getString(ANIMAL));

        if (!data.getString(ANIMAL).equals("Котики")) {
            startInd = 6;
        }

        Context appContext = getApplicationContext();
        if (appContext instanceof AnimalApp) {
            SoundManager soundManager = ((AnimalApp) appContext).getSoundManager();
            play1.setOnClickListener(view -> soundManager.play(startInd));
            play2.setOnClickListener(view -> soundManager.play(startInd + 1));
            play3.setOnClickListener(view -> soundManager.play(startInd + 2));
            play4.setOnClickListener(view -> soundManager.play(startInd + 3));
            play5.setOnClickListener(view -> soundManager.play(startInd + 4));
            play6.setOnClickListener(view -> soundManager.play(startInd + 5));
        }
    }
}