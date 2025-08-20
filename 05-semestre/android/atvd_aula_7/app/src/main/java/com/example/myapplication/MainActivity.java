package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Digits;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements Validator
        .ValidationListener {
    @NotEmpty(message = "Name is a mandatory field.")
    @Length(min = 3)
    private EditText nameInput;

    @NotEmpty
    @Email(message = "Invalid email.")
    private EditText emailInput;

    @NotEmpty
    @Length(min = 10)
    private EditText messageInput;

    @Select(message = "The selections is mandatory.", defaultSelection = 0)
    private Spinner spinner;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        messageInput = findViewById(R.id.messageInput);
        spinner = findViewById(R.id.spinner);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);

        adapter.add("Progamming Language: ");
        adapter.add("Javascript");
        adapter.add("Typescript");
        adapter.add("Java");
        adapter.add("C++");

        spinner.setAdapter(adapter);

        Validator validator = new Validator(this);
        validator.setValidationListener(this);

        Button validateBtn = findViewById(R.id.validateBtn);
        validateBtn.setOnClickListener(v -> {
            validator.validate();
        });
    }

    @Override
    public void onValidationSucceeded() {
        new AlertDialog.Builder(this).setTitle("Confirm: ")
                .setMessage("Your name: " + nameInput.getText() + "\nYour email: " + emailInput.getText() + "\nYour message: " + messageInput.getText() + "\nYour favorite language: " + spinner.getSelectedItem().toString())
                .setPositiveButton("Yes", ((dialog, which) -> {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                })).setNegativeButton("No", (dialog, which) -> {
                    Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
                }).show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View component = error.getView();

            if (component instanceof EditText) {
                ((EditText)component).setError(error.getCollatedErrorMessage(this));
            }
//            if (component instanceof Spinner) {
//                ((Spinner)component).setError(error.getCollatedErrorMessage(this));
//            }
        }
    }
}