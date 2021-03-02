package com.example.mirand.ui.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mirand.R;

public class activity_login extends AppCompatActivity {
    private EditText phone, code;
    private TextView cannotAuth;
    private Button sendCode,enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone=(EditText) findViewById(R.id.send_to_this_phone_text);//поле телефона
        code=(EditText) findViewById(R.id.sms_code_text);//поле ввода кода
        sendCode=(Button)findViewById(R.id.send_code);//кнопка отправки кода
        enter=(Button)findViewById(R.id.enter_main_app_button);//поле входа
        cannotAuth=(TextView)findViewById(R.id.cant_auth_login_text);//если не удалось войти
        cannotAuth.setVisibility(View.INVISIBLE);
        sendCode.setOnClickListener(view -> {
            if (phone.getText().toString().startsWith("+7")||phone.getText().toString().startsWith("8")
                    &&phone.getText().toString().length()>10&&phone.getText().toString().length()<13){
                //todo отправить код фаербейсом
            }
            else cannotAuth.setVisibility(View.VISIBLE);
        });
        enter.setOnClickListener(view -> {
            if (!code.getText().toString().isEmpty()){
                //todo если код верен, то войти в прогу под своим аккаунтом (надо получить данные юзера, мб)
            }
        });
    }
}