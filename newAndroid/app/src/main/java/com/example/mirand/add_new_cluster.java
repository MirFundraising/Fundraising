package com.example.mirand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class add_new_cluster extends AppCompatActivity {
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_cluster);
        phone=(EditText) findViewById(R.id.new_cluster_user_phone_text);
    }
}