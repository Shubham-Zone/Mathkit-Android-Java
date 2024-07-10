package com.Mathkit.gpsuplani;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TrigoAngles extends AppCompatActivity {

    private AutoCompleteTextView mAutoCompleteTextView;
    private EditText mAngleEditText;
    private Button mAngleButton;
    private TextView mAngleValueTextView;

    private DecimalFormat mDecimalFormat;

    private static final String[] TRIGO_FUNCTIONS = new String[] {
            "sin", "cos", "tan", "csc", "sec", "cot"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigo_angles);

        // Initialize UI elements
        mAutoCompleteTextView = findViewById(R.id.auto_complete_txt);
        mAngleEditText = findViewById(R.id.angle);
        mAngleButton = findViewById(R.id.anglebtn);
        mAngleValueTextView = findViewById(R.id.AngleValue);

        // Initialize decimal format to display fractions
        mDecimalFormat = new DecimalFormat("#.####");
        mDecimalFormat.setRoundingMode(RoundingMode.CEILING);

        // Set up the dropdown list for the trigo functions
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, TRIGO_FUNCTIONS);
        mAutoCompleteTextView.setAdapter(adapter);

        // Handle the click event for the button
        mAngleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String angleStr = mAngleEditText.getText().toString().trim();
                String function = mAutoCompleteTextView.getText().toString().trim();

                // Validate input
                if (TextUtils.isEmpty(angleStr)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter an angle", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(function)) {
                    Toast.makeText(getApplicationContext(),
                            "Please select a function", Toast.LENGTH_SHORT).show();
                    return;
                }

                double angle = Double.parseDouble(angleStr);
                String value = "";
                double value1 = 0.0;

                // Calculate the value of the trigo function
                switch (function) {
                    case "sin":
                        if (angle == 30) {
                            value = "1/2";
                        } else if (angle == 45) {
                            value = "1/√2";
                        } else if (angle == 60) {
                            value = "√3/2";
                        } else if (angle == 90) {
                            value = "1";
                        } else {
                            value1 = Math.sin(Math.toRadians(angle));
                        }
                        break;
                    case "cos":
                        if (angle == 30) {
                            value = "√3/2";
                        } else if (angle == 45) {
                            value = "1/√2";
                        } else if (angle == 60) {
                            value = "1/2";
                        } else if (angle == 90) {
                            value = "0";
                        } else {
                            value1 = Math.cos(Math.toRadians(angle));
                        }
                        break;
                    case "tan":
                        if (angle == 30) {
                            value = "1/√3";
                        } else if (angle == 45) {
                            value = "1";
                        } else if (angle == 60) {
                            value = "√3";
                        } else if (angle == 90) {
                            value="Not defined";
                        } else {
                            value1 = Math.tan(Math.toRadians(angle));
                        }
                        break;
                    case "csc":
                        if (angle == 30) {
                            value = "2";
                        } else if (angle == 45) {
                            value = "√2";
                        } else if (angle == 60) {
                            value = "2/√3";
                        } else if (angle == 90) {
                            value = "1";
                        } else {
                            value1 = 1.0 / Math.sin(Math.toRadians(angle));
                        }
                        break;
                    case "sec":
                        if (angle == 30) {
                            value = "2/√3";
                        } else if (angle == 45) {
                            value = "√2";
                        } else if (angle == 60) {
                            value = "2";
                        } else if (angle == 90) {
                            value = "undefined";
                        } else {
                            value1 = 1.0 / Math.cos(Math.toRadians(angle));
                        }
                        break;
                    case "cot":
                        if (angle == 30) {
                            value = "√3";
                        } else if (angle == 45) {
                            value = "1";
                        } else if (angle == 60) {
                            value = "1/√3";
                        } else if (angle == 90) {
                            value="0";
                        } else {
                            value1 = 1.0 / Math.tan(Math.toRadians(angle));
                        }
                        break;
                }

                // Display the result
                String result;
                if (angle == 30 || angle == 45 || angle == 60 || angle==90) {
//                    int numerator, denominator;
//                    if (value % 1 == 0) {
//                        numerator = (int) value;
//                        denominator = 1;
//                    } else {
//                        int maxFactor = findMaxFactor(value);
//                        numerator = (int) (value * maxFactor);
//                        denominator = maxFactor;
//                    }
                    result = function + angle + "°" + " = " + value;
                } else {
                    result = function + "(" + angle + ") = " + mDecimalFormat.format(value1);
                }

                mAngleValueTextView.setText(result);
            }
            private int findMaxFactor(double value) {
                                                int maxFactor = 1;
                                                for (int i = 2; i <= 1000; i++) {
                                                    if (value * i % 1 == 0) {
                                                        maxFactor = i;
                                                    }
                                                }
                                                return maxFactor;
                                            }
        });
    }
}









