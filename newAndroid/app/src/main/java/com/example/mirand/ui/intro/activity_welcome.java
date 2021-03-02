package com.example.mirand.ui.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mirand.R;

public class activity_welcome extends AppCompatActivity {
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        continueButton=(Button)findViewById(R.id.enter_button);
        continueButton.setOnClickListener(view -> {
            startActivity(new Intent(activity_welcome.this,activity_login.class));
        });
    }
}