package com.example.mirand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class add_new_cluster extends AppCompatActivity {
    private EditText phone;
    private EditText dedline;
    private EditText date;
    private EditText time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_cluster);
        phone=(EditText) findViewById(R.id.new_cluster_user_phone_text);
        dedline=(EditText) findViewById(R.id.end_of_date_new_cluster);
        date=(EditText) findViewById(R.id.choose_date);
        time=(EditText) findViewById(R.id.choose_time);
    }
}