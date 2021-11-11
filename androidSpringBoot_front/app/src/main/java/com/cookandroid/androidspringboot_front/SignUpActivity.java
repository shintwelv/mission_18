package com.cookandroid.androidspringboot_front;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cookandroid.androidspringboot_front.retrofit.User;
import com.cookandroid.androidspringboot_front.retrofit.UserApi;
import com.squareup.moshi.Moshi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class SignUpActivity extends AppCompatActivity {
    private final  String TAG = getClass().getSimpleName();

    Button btnCancel, btnSignUp;
    EditText idInput, pwInput, nameInput, emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        idInput = (EditText) findViewById(R.id.idInput);
        pwInput = (EditText) findViewById(R.id.pwInput);
        nameInput = (EditText) findViewById(R.id.nameInput);
        emailInput = (EditText) findViewById(R.id.emailInput);


        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idInput.getText().toString();
                String pw = pwInput.getText().toString();
                String name = nameInput.getText().toString();
                String email = emailInput.getText().toString();

                User signUpInfo = new User();
                signUpInfo.setUserId(id);
                signUpInfo.setUserPassword(pw);
                signUpInfo.setUserName(name);
                signUpInfo.setUserEmail(email);

                Moshi moshi = new Moshi.Builder().build();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.0.8:9930/")
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
                        .build();

                UserApi api = retrofit.create(UserApi.class);

                Call<Boolean> call = api.createUser(signUpInfo);
                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        boolean signUpSuccess = response.body();

                        if (signUpSuccess){
                            Intent intent = new Intent(getApplicationContext(),  MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Log.d(TAG,"Fail msg : " + t.getMessage());
                        Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}