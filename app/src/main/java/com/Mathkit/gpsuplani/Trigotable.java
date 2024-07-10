package com.Mathkit.gpsuplani;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Trigotable extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigotable);
        Objects.requireNonNull(getSupportActionBar()).hide();

    }
}