package com.example.mirand.ui.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mirand.R;

public class activity_welcome extends AppCompatActivity {
    private Button continueButton;

    private Button mEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
<<<<<<< HEAD

        mEnter = findViewById(R.id.enter_button);

        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_login.class);
                startActivity(intent);
            }
=======
        continueButton=(Button)findViewById(R.id.enter_button);
        continueButton.setOnClickListener(view -> {
            startActivity(new Intent(activity_welcome.this,activity_login.class));

>>>>>>> bea3c611d16272ea48a6d5c9af7ad5711647270e
        });
    }
}