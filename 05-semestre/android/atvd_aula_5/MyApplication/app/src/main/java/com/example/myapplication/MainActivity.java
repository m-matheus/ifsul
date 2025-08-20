package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button bt;
    private EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        this.bt = findViewById(R.id.button);
        this.inputText = findViewById(R.id.editTextText);

        this.bt.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            String name = inputText.getText().toString();
            i.putExtra("name", name);
            startActivity(i);
        });
    }
}