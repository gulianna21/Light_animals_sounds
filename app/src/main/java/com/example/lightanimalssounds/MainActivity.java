package com.example.lightanimalssounds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button start;
    String selectionAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        start = findViewById(R.id.start);

        this.initialSpinner();

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectionAnimal= (String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectionAnimal=getResources().getStringArray(R.array.animals)[0];
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);

        start.setOnClickListener(view->
                startActivity(new Intent(MainActivity.this, SoundsScreen.class).putExtra(SoundsScreen.ANIMAL, this.selectionAnimal)));
    }

    private void initialSpinner() {
        String[] animals = getResources().getStringArray(R.array.animals);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, animals);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}