package com.example.mirand.ui.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mirand.MainActivity;
import com.example.mirand.R;

import org.w3c.dom.Text;

public class activity_register extends AppCompatActivity {
    private EditText name, surname,birthDate,email;
    private Button register;
    private String phoneNumber;
    private static final String TAG = "activity_register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name= (EditText) findViewById(R.id.user_name);//поле имени
        surname= (EditText) findViewById(R.id.user_surname);//поле фамилии
        birthDate= (EditText) findViewById(R.id.birth_date);//поле даты рождения
        email= (EditText) findViewById(R.id.email_text);//поле email
        register=(Button)findViewById(R.id.continue_button);//кнопка регистрации
        phoneNumber = getIntent().getStringExtra("PHONE_NUMBER");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean noEmptyFields= !(name.getText().toString().isEmpty())
                        && !(surname.getText().toString().isEmpty())
                        && !(birthDate.getText().toString().isEmpty())
                        && !(email.getText().toString().isEmpty());

                if (noEmptyFields) {
                    Log.v(TAG, String.valueOf(noEmptyFields));

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });

    }
}