package com.Mathkit.gpsuplani;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import java.util.Objects;

public class squareroot extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squareroot);
        Objects.requireNonNull(getSupportActionBar()).hide();

        EditText editText=findViewById(R.id.sqrtEdittext);
        TextView textView=findViewById(R.id.sqrtres);

        findViewById(R.id.sqrtbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x=editText.getText().toString();

                if(x.isEmpty()){
                    Toast.makeText(squareroot.this, "Please enter no", Toast.LENGTH_SHORT).show();
                }else{
                    Double n=Double.parseDouble(x);
                    double y=Math.sqrt(n);
                    textView.setText("Square root of " +x+" is "+String.valueOf(y));
                    editText.setText("");
                }
            }
        });



    }
}