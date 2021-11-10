package com.cookandroid.androidspringboot_front;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnCancel, btnSignUp, btnSignIn, btnGoSignUp;
    EditText signInId, signInPw, idInput, pwInput, nameInput, emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCancel = findViewById(R.id.btnCancel);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnGoSignUp = findViewById(R.id.btnGoSignUp);
        btnSignIn = findViewById(R.id.btnSignIn);

        signInId = findViewById(R.id.signInId);
        signInPw = findViewById(R.id.signInPw);

        idInput = findViewById(R.id.idInput);
        pwInput = findViewById(R.id.pwInput);
        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
    }
}