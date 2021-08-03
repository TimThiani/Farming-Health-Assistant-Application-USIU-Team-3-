package com.example.farmhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateUs extends AppCompatActivity {

    EditText editTextTextMultiLine;
    RatingBar ratingBar;
    Button btnSubmit2;

    float myRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnSubmit2 = findViewById(R.id.btnSubmit2);
        ratingBar = findViewById(R.id.ratingBar);
        editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);


        btnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {

                        int rating = (int) v;
                        String message = null;
                        myRating = ratingBar.getRating();

                        switch (rating){
                            case 1:
                                message = "Sorry to hear that :(";
                                    break;
                            case 2:
                                message = "You always accept suggestions";
                                break;
                            case 3:
                                message = "Good Enough";
                                break;
                            case 4:
                                message = "Great, Thank You!";
                                break;
                            case 5:
                                message = "Awesome! You are the best";
                                break;
                        }
                        Toast.makeText(RateUs.this, message, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RateUs.this, String.valueOf(myRating), Toast.LENGTH_SHORT).show();
            }
        });
    }
}