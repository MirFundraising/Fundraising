package com.example.mirand.ui.adds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.mirand.R;

public class add_new_cluster extends AppCompatActivity {
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_cluster);
        phone=(EditText) findViewById(R.id.new_cluster_user_phone_text);
    }
}