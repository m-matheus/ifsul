package br.ifsul;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button button;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("PrtSc Aula", "Create");
        this.text = findViewById(R.id.text1);
        this.button = findViewById(R.id.button1);

        this.button.setOnClickListener( v -> {
            counter++;
            this.text.setText(String.valueOf(counter));

        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("PrtSc Aula", "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("PrtSc Aula", "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("PrtSc Aula", "Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("PrtSc Aula", "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("PrtSc Aula", "Destroy");
    }
}