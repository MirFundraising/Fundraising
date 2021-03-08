package com.example.mirand.ui.intro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
<<<<<<< HEAD
import android.net.Uri;
=======
>>>>>>> bea3c611d16272ea48a6d5c9af7ad5711647270e
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< HEAD
import android.widget.Toast;
=======
import android.widget.TextView;
>>>>>>> bea3c611d16272ea48a6d5c9af7ad5711647270e

import com.example.mirand.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class activity_login extends AppCompatActivity {
<<<<<<< HEAD

    private Button mSendCode;
    private Button mLogIn;
    private EditText mPhoneNumber;
    private EditText mCode;
    private String id;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

=======
    private EditText phone, code;
    private TextView cannotAuth,registerSwitch;
    private Button sendCode,enter;
>>>>>>> bea3c611d16272ea48a6d5c9af7ad5711647270e
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
<<<<<<< HEAD

        mSendCode = findViewById(R.id.send_code);
        mLogIn = findViewById(R.id.enter_main_app_button);
        mPhoneNumber = findViewById(R.id.send_to_this_phone_text);
        mCode = findViewById(R.id.sms_code_text);
        mAuth = FirebaseAuth.getInstance();

        mLogIn.setVisibility(View.INVISIBLE);
        mCode.setFocusable(false);

        mSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = mPhoneNumber.getText().toString();
                if(phoneNumber.isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Phone Number is empty!", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                } else {
                    PhoneAuthOptions options =
                            PhoneAuthOptions.newBuilder(mAuth)
                                    .setPhoneNumber(phoneNumber)       // Phone number to verify
                                    .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                    .setActivity(activity_login.this)                 // Activity (for callback binding)
                                    .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                                    .build();
                    PhoneAuthProvider.verifyPhoneNumber(options);

                    mLogIn.setVisibility(View.VISIBLE);
                    mCode.setFocusableInTouchMode(true);
                }
            }
        });

        mLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = mCode.getText().toString();

                PhoneAuthCredential phoneAuthCredential =
                        PhoneAuthProvider.getCredential(id, code);

                mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Uri uri;
                            Intent intent = new Intent(getApplicationContext(), activity_register.class);
                            startActivity(intent);
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Wrong OTP code!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                });
            }
        });

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                mLogIn.setVisibility(View.INVISIBLE);
                mCode.setFocusable(false);
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                id = s;
                Toast toast = Toast.makeText(getApplicationContext(),
                        "OTP has been sent!", Toast.LENGTH_SHORT);
                toast.show();
            }
        };
=======
        phone=(EditText) findViewById(R.id.send_to_this_phone_text);//поле телефона
        code=(EditText) findViewById(R.id.sms_code_text);//поле ввода кода
        sendCode=(Button)findViewById(R.id.send_code);//кнопка отправки кода
        enter=(Button)findViewById(R.id.enter_main_app_button);//поле входа
        cannotAuth=(TextView)findViewById(R.id.cant_auth_login_text);//если не удалось войти
        cannotAuth.setVisibility(View.INVISIBLE);
        registerSwitch=(TextView)findViewById(R.id.go_to_register_text);

        registerSwitch.setOnClickListener(view -> {
            startActivity(new Intent(activity_login.this,activity_register.class));
        });
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
>>>>>>> bea3c611d16272ea48a6d5c9af7ad5711647270e
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser == null) {
//            startActivity(new In);
//        }
//    }
}