package com.example.mirand.ui.intro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.mirand.R;
import com.example.mirand.database.DBHandler;
import com.example.mirand.util.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class activity_login extends AppCompatActivity {
    private static final String TAG = "activity_login";
    private Button mSendCode;
    private Button mLogIn;
    private EditText mPhoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private EditText mCode;
    private String id;
    private String phoneNumber;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
                phoneNumber = mPhoneNumber.getText().toString();
                if(phoneNumber.isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Phone Number is empty!", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                } else {
                    Log.v(TAG, phoneNumber);

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
                if(!code.isEmpty()) {
                    PhoneAuthCredential phoneAuthCredential =
                            PhoneAuthProvider.getCredential(id, code);

                    mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Intent intent = new Intent(getApplicationContext(), activity_register.class);
                                intent.putExtra("PHONE_NUMBER", phoneNumber);
                                startActivity(intent);
                            } else {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Wrong OTP code!", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }
                    });
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "No OTP Code!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Intent intent = new Intent(getApplicationContext(), activity_register.class);
                            intent.putExtra("PHONE_NUMBER", phoneNumber);
                            startActivity(intent);
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Wrong OTP code!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                });
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
    }
}