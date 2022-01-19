package com.example.lightanimalssounds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class SoundsScreen extends AppCompatActivity {
    public static final String ANIMAL = "Animal";

    private SoundViewModel viewModel;

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
        animal.setTextColor(getResources().getColor(R.color.white, getTheme()));

        if (TextUtils.equals(data.getString(ANIMAL), "Котики")) {
            viewModel = new ViewModelProvider(this).get(CatsSoundViewModel.class);
        } else {
            viewModel = new ViewModelProvider(this).get(AnimalsSoundViewModel.class);
        }

        play1.setOnClickListener(view -> viewModel.onPlaySound(SoundViewModel.SOUND1));
        play2.setOnClickListener(view -> viewModel.onPlaySound(SoundViewModel.SOUND2));
        play3.setOnClickListener(view -> viewModel.onPlaySound(SoundViewModel.SOUND3));
        play4.setOnClickListener(view -> viewModel.onPlaySound(SoundViewModel.SOUND4));
        play5.setOnClickListener(view -> viewModel.onPlaySound(SoundViewModel.SOUND5));
        play6.setOnClickListener(view -> viewModel.onPlaySound(SoundViewModel.SOUND6));
    }
}