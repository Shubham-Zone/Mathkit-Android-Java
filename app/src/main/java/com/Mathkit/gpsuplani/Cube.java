package com.Mathkit.gpsuplani;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Cube extends AppCompatActivity {

    EditText Cube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);
        Objects.requireNonNull(getSupportActionBar()).hide();

        EditText ed=findViewById(R.id.cubeedtxt);
        TextView txt=findViewById(R.id.cuberes);
        Button btn=findViewById(R.id.cubebtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String x=ed.getText().toString();

                if(x.isEmpty()){
                    Toast.makeText(Cube.this, "Please enter no", Toast.LENGTH_SHORT).show();
                }else{
                    double n = Double.parseDouble(x);
                    // convert double to integer
                    int z=(int) n;
                    if(n!=z){
                        double res=n*n*n;
                        txt.setText("Cube of " +x+" is "+String.valueOf(res));
                        ed.setText("");
                    }else{
                        int y=Integer.parseInt(x);
                        int res=y*y*y;
                        txt.setText("Cube of " +x+" is "+String.valueOf(res));
                        ed.setText("");
                    }
                }


            }
        });


    }
}