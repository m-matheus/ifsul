package com.example.brifsul;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber = (new Random()).nextInt(10) + 1;
    int guessedNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button guess = findViewById(R.id.guess);
        Button reset = findViewById(R.id.reset);
        TextView hint = findViewById(R.id.hint);
        TextView tries = findViewById(R.id.tries);
        EditText guessInput = findViewById(R.id.editTextText);

        guess.setOnClickListener(v -> {
            int guessNumber = Integer.parseInt(guessInput.getText().toString());
            guessedNumber++;

            tries.setText("Tries: " + guessedNumber);

            if (guessNumber == randomNumber) {
                hint.setText("Congratulations!!!");
            } else {
                if (guessNumber > randomNumber) {
                    hint.setText("Try a lower number");
                } else {
                    hint.setText("Try a higher number");
                }
            }
        });

        reset.setOnClickListener((v)-> {
            randomNumber = (new Random()).nextInt(10) + 1;
            guessedNumber = 0;

            hint.setText("");
            guessInput.setText("");
            tries.setText("Tries: " + guessedNumber);
        });
    }
}