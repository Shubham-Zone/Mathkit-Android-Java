package com.Mathkit.gpsuplani;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Objects.requireNonNull(getSupportActionBar()).hide();

        findViewById(R.id.sqroot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index.this,squareroot.class));
            }
        });

        findViewById(R.id.square).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index.this,
                        Square.class));
            }
        });

        findViewById(R.id.cube).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index.this,Cube.class));
            }
        });

        findViewById(R.id.mul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index.this, MainActivity.class));
            }
        });

        findViewById(R.id.fact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index.this,Factorial.class));
            }
        });

        findViewById(R.id.Trigo_table).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index.this,Trigotable.class));
            }
        });

        findViewById(R.id.Trigo_angle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index.this, TrigoAngles.class));
            }
        });



    }
}