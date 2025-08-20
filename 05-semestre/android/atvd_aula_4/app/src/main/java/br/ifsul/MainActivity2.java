package br.ifsul;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private TextView text3;
    private EditText inputText;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.text3 = findViewById(R.id.textView3);
        this.button2 = findViewById(R.id.button2);
        this.inputText = findViewById(R.id.inputText);

        this.button2.setOnClickListener( v -> {

            String data = inputText.getText().toString();

            this.text3.setText("Número de palavras: "+String.valueOf(data.split(" ").length)+ "\n"+ "Número de carácteres: "+String.valueOf(data.length()));
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        });

    }
}