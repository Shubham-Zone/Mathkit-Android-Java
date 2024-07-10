package com.Mathkit.gpsuplani;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Factorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);
        Objects.requireNonNull(getSupportActionBar()).hide();

        EditText editText=findViewById(R.id.facted);
        TextView textView=findViewById(R.id.factres);


        findViewById(R.id.factbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=editText.getText().toString();

                if(n.isEmpty()){
                    Toast.makeText(Factorial.this, "Please enter no", Toast.LENGTH_SHORT).show();
                }else{
                    long factorial = 1;
                    for(int i = 1; i <= Integer.valueOf(n); ++i)
                    {
                        // factorial = factorial * i;
                        factorial *= i;
                        textView.setText("Factorial of " +n+" is "+String.valueOf(factorial));
                        editText.setText("");
                    }
                }

            }
        });
    }
}