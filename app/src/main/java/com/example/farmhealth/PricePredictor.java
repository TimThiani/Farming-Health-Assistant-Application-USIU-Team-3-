package com.example.farmhealth;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PricePredictor extends AppCompatActivity {

    Spinner spinnerBreed, spinnerCounty, spinnerGender;
    Button btnSubmit;
    String[] breed;
    String[] county;
    EditText edittxtAge, edittxtWeight;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerBreed = findViewById(R.id.spinnerBreed);
        spinnerCounty = findViewById(R.id.spinnerCounty);
        spinnerGender = findViewById(R.id.spinnerGender);

        btnSubmit = findViewById(R.id.btnSubmit);
        edittxtAge = findViewById(R.id.edittxtAge);
        edittxtWeight = findViewById(R.id.edittxtWeight);
        result = findViewById(R.id.result);

        populateSpinnerBreed();
        populateSpinnerCounty();
        populateSpinnerGender();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String breed = spinnerBreed.getSelectedItem().toString();
                String county = spinnerCounty.getSelectedItem().toString();
                String gender = spinnerGender.getSelectedItem().toString();
                Toast.makeText(PricePredictor.this,breed+ ", "+ county, Toast.LENGTH_SHORT).show();

                double age = Double.parseDouble (edittxtAge.getText().toString());
                double weight = Double.parseDouble (edittxtWeight.getText().toString());

                if((age<=1) && (weight<=500)){
                    result.setText("Predicted Price: " + "Kshs 120,000");
                }
                else if((age<=1.5) && (weight<=650)){
                    result.setText("Predicted Price: " + "Kshs 150,000");
                }
                else if((age<=2) && (weight<=750)){
                    result.setText("Predicted Price: " + "Kshs 180,000");
                }
                else if((age<=2.5) && (weight<=800)){
                    result.setText("Predicted Price: " + "Kshs 200,000");
                }
                else if((age<=3) && (weight<=820)){
                    result.setText("Predicted Price: " + "Kshs 250,000");
                }
                else if((age<=3.5) && (weight<=850)){
                    result.setText("Predicted Price: " + "Kshs 300,000");
                }
                else if((age>3.5) && (weight<=900)){
                    result.setText("Predicted Price: " + "Kshs 500,000");
                }

            }
        });

    }

    private void populateSpinnerGender() {
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner_gender));
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(genderAdapter);
    }

    private void populateSpinnerCounty() {
        ArrayAdapter<String> countyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner_county));
        countyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCounty.setAdapter(countyAdapter);
    }

    private void populateSpinnerBreed() {
        ArrayAdapter<String> breedAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner_breed));
        breedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBreed.setAdapter(breedAdapter);
    }

}