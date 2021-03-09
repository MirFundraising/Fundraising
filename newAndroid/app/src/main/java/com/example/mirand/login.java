package com.example.mirand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class login extends AppCompatActivity {
    private EditText phone;
    private EditText code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_cluster);
        phone=(EditText) findViewById(R.id.send_to_this_phone_text);
        code=(EditText) findViewById(R.id.sms_code_text);
    }
}