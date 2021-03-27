package com.example.mirand.ui.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mirand.MainActivity;
import com.example.mirand.R;
import com.google.firebase.auth.FirebaseAuth;

public class activity_welcome extends AppCompatActivity {
    private static final String TAG = "activity_welcome";
    private Button mEnter;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mEnter = findViewById(R.id.enter_button);
        mAuth = FirebaseAuth.getInstance();

        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAuth.getCurrentUser() == null) {
                    startActivity(new Intent(getApplicationContext(), activity_login.class));
                    finish();
                }
                else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }
}