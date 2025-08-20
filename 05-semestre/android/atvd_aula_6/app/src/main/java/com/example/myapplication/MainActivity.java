package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox pao = findViewById(R.id.checkBoxPao);
        CheckBox alface = findViewById(R.id.checkBoxAlface);
        CheckBox tomate = findViewById(R.id.checkBoxTomate);
        CheckBox cebola = findViewById(R.id.checkBoxCebola);
        CheckBox queijo = findViewById(R.id.checkBoxQueijo);
        CheckBox carne = findViewById(R.id.checkBoxCarne);

        ImageView topo = findViewById(R.id.imageViewPaoCima);
        ImageView baixo = findViewById(R.id.imageViewPaoBaixo);
        ImageView alfaceImg = findViewById(R.id.imageViewAlface);
        ImageView tomateImg = findViewById(R.id.imageViewTomate);
        ImageView cebolaImg = findViewById(R.id.imageViewCebola);
        ImageView queijoImg = findViewById(R.id.imageViewQueijo);
        ImageView carneImg = findViewById(R.id.imageViewCarne);

        Button btConfirmarPedido = findViewById(R.id.buttonConfirmarPedido);

        btConfirmarPedido.setOnClickListener(v -> {
            topo.setImageResource(android.R.drawable.editbox_background);
            baixo.setImageResource(android.R.drawable.editbox_background);
            alfaceImg.setImageResource(android.R.drawable.editbox_background);
            tomateImg.setImageResource(android.R.drawable.editbox_background);
            cebolaImg.setImageResource(android.R.drawable.editbox_background);
            queijoImg.setImageResource(android.R.drawable.editbox_background);
            carneImg.setImageResource(android.R.drawable.editbox_background);

            if(pao.isChecked()) {
                topo.setImageResource(R.drawable.pao_cima);
                baixo.setImageResource(R.drawable.pao_baixo);
            }
            if(alface.isChecked()) {
                alfaceImg.setImageResource(R.drawable.alface);
            }
            if(tomate.isChecked()) {
                tomateImg.setImageResource(R.drawable.tomate);
            }
            if(cebola.isChecked()) {
                cebolaImg.setImageResource(R.drawable.cebola);
            }
            if(queijo.isChecked()) {
                queijoImg.setImageResource(R.drawable.queijo);
            }
            if(carne.isChecked()) {
                carneImg.setImageResource(R.drawable.carne);
            }
        });
    }
}