package com.Mathkit.gpsuplani;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Square extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);
        Objects.requireNonNull(getSupportActionBar()).hide();

        EditText ed=findViewById(R.id.sqed);
        TextView txt=findViewById(R.id.sqres);
        Button btn=findViewById(R.id.sqbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x=ed.getText().toString();

               if(x.isEmpty()){
                   Toast.makeText(Square.this, "Please enter no", Toast.LENGTH_SHORT).show();
               }else{
                   double n = Double.parseDouble(x);
                   // convert double to integer
                   int z=(int) n;

                   if(n!=z){
                       double res=n*n;
                       txt.setText("Square of " +x+" is "+String.valueOf(res));
                       ed.setText("");
                   }else{
                       int y=Integer.parseInt(x);
                       int res=y*y;
                       txt.setText("Square of " +x+" is "+String.valueOf(res));
                       ed.setText("");
                   }
               }

            }
        });


    }
}