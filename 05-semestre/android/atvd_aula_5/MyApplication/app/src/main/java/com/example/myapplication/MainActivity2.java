package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private Button bt2;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        this.bt2 = findViewById(R.id.button2);
        this.textView3 = findViewById(R.id.textView3);

        Intent i = getIntent();
        String name = i.getStringExtra("name");

        this.textView3.setText("Your name is " + name);

        this.bt2.setOnClickListener(v -> {
            //            startActivity(i);
            finish();
        });
    }
}