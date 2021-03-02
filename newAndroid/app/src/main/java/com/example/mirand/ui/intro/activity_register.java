package com.example.mirand.ui.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mirand.R;

public class activity_register extends AppCompatActivity {
    private EditText name, surname,birthDate,email,phone,code;
    private TextView cannotAuth;
    private Button register,sendCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name= (EditText) findViewById(R.id.user_name);//поле имени
        surname= (EditText) findViewById(R.id.user_surname);//поле фамилии
        birthDate= (EditText) findViewById(R.id.birth_date);//поле даты рождения
        email= (EditText) findViewById(R.id.email_text);//поле email
        phone= (EditText) findViewById(R.id.phone_number_text);//поле телефона
        code=(EditText)findViewById(R.id.get_sms_code_text);//поле кода регистрации
        sendCode=(Button) findViewById(R.id.send_register_code);//кнопка отправки кода
        register=(Button)findViewById(R.id.continue_button);//кнопка регистрации
        cannotAuth=(TextView)findViewById(R.id.cant_auth_register_text);
        cannotAuth.setVisibility(View.INVISIBLE);
        boolean noEmptyFields=!name.getText().toString().isEmpty()&&!surname.getText().toString().isEmpty()
                &&!birthDate.getText().toString().isEmpty()&&!email.getText().toString().isEmpty()&&!phone.getText().toString().isEmpty();//проверка полей

        sendCode.setOnClickListener(view -> {
            if (noEmptyFields){
                //TODO отправить код подтверждения на телефон
            }
            else cannotAuth.setVisibility(View.VISIBLE);
        });
        register.setOnClickListener(view -> {
            if (noEmptyFields&&!code.getText().toString().isEmpty()){
                //todo отправить все данные на сервак для проверки ликвидности
            }
            else cannotAuth.setVisibility(View.VISIBLE);
            //todo сюда мы попадаем, если все ок, тогда мы авторизовываем
            // автоматически пользователя и прокидываем его в main activity
        });
    }
}