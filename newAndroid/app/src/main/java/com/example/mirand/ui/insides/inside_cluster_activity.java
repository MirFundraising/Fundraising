package com.example.mirand.ui.insides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mirand.R;

public class inside_cluster_activity extends AppCompatActivity {
    private EditText clusterName;
    private EditText clusterRole;
    private RecyclerView fundraisings;
    private RecyclerView users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_cluster_activity);
        clusterName= (EditText)findViewById(R.id.inside_cluster_name_text);
        clusterRole= (EditText)findViewById(R.id.inside_cluster_role_text);
        fundraisings= (RecyclerView)findViewById(R.id.fundraising_recycler);
        users= (RecyclerView)findViewById(R.id.cluster_users_recycler);

    }
    public void addNewMember(View view){

    }
    public void addNewFundraising(View view){

    }
}