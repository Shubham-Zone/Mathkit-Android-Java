package com.Mathkit.gpsuplani;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText enterno;
    Button button;
    TextView Result;
    ImageView imageView;
    double ans = 0.0;
    int ans1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        enterno=findViewById(R.id.enterno);
        button=findViewById(R.id.presshere);
        Result=findViewById(R.id.Result);


            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(this.getResources().getColor(R.color.white));
        }


//        imageView.setImageResource(R.drawable.think);
        Objects.requireNonNull(getSupportActionBar()).setTitle("MULTIPLICATION TABLE");
        //define ActionBar object
        ActionBar actionBar;
        actionBar =getSupportActionBar();
        /* Define ColorDrawable object and parse color
         * using parseColor method
         * with color hash code as its parameter*/
        ColorDrawable colorDrawable
                =new ColorDrawable(Color.parseColor("#FF4500"));

        //set background
        actionBar.setBackgroundDrawable(colorDrawable);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuffer buffer = new StringBuffer();
                int res;

                // get the input number from editText
                String fs = enterno.getText().toString();


                if(fs.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter no", Toast.LENGTH_SHORT).show();
                }else{
                    // convert string to double
                    double n = Double.parseDouble(fs);

                    // convert double to integer
                    int x=(int) n;

                    if(n!=x){
                        // build the logic for double table
                        for (int i = 1; i <= 10; i++) {
                            ans = (i * n);
                            double roundOff = Math.round(ans*1000.0)/1000.0;
                            buffer.append(n + " X " + i
                                    + " = " + roundOff + "\n\n");
                        }
                        Result.setText(buffer);
                        enterno.setText("");

                    }else{

                        // build the logic for integer table
                        for (int i = 1; i <= 10; i++) {
                            ans1 = (i * x);
                            buffer.append(x + " X " + i
                                    + " = " + ans1 + "\n\n");
                        }
                        Result.setText(buffer);
                        enterno.setText("");
                    }
                }



            }

        });
    }


}