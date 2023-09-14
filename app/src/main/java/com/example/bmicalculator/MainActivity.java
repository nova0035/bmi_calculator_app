package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static double calculateBMI(double weight,double height){

        return  weight / (height * height);
    }

    EditText weight, height;
    TextView message;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI elements
        weight = findViewById(R.id.weight_input);
        height = findViewById(R.id.height_input);
        message = findViewById(R.id.bmi_details);
        calculate = findViewById(R.id.calculate_button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_weight = weight.getText().toString().trim();
                String input_height = height.getText().toString().trim();

                if(input_weight.isEmpty() && input_height.isEmpty()){
                    weight.setError("This field is required");
                    height.setError("This field is required");
                }

                else if (input_weight.isEmpty()) {
                    weight.setError("This field is required");
                }

                else if (input_height.isEmpty()) {
                    height.setError("This field is required");
                }

                else{

                    double weight = Double.parseDouble(input_weight);
                    double height = Double.parseDouble(input_height);

                    String status;
                    double BMI = calculateBMI(weight,height);
                    if(BMI < 18.5){
                        status = "UnderWeight";
                    }
                    else if(BMI >= 18.5 && BMI < 24.9){
                        status = "Normal";
                    }
                    else if(BMI >= 25.0 && BMI < 29.9){
                        status = "OverWeight";
                    }
                    else{
                        status = "Obese";
                    }

                    String displayMessage = String.format("Your BMI Is %.2f And You Are %s", BMI, status);
                    message.setText(displayMessage);
                }




            }
        });
    }
}
