package com.example.mirand.ui.insides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mirand.R;
import com.example.mirand.ui.adds.create_new_fundraising;
import com.example.mirand.util.Cluster;
import com.example.mirand.util.Permission;
import com.example.mirand.util.User;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class inside_cluster_activity extends AppCompatActivity {
    private TextView clusterName;
    private TextView clusterRole;
    private RecyclerView fundraisings;
    private RecyclerView users;
    private Cluster cluster;
    private ArrayList<User> members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_cluster_activity);
        clusterName= (TextView)findViewById(R.id.inside_cluster_name_text);
        clusterRole= (TextView)findViewById(R.id.inside_cluster_role_text);
        fundraisings= (RecyclerView)findViewById(R.id.fundraising_recycler);
        users= (RecyclerView)findViewById(R.id.cluster_users_recycler);
        clusterName.setText(cluster.getName());
        clusterRole.setText(Permission.Administrator.toString());
    }
    public void addNewMember(View view){
        startActivity(new Intent());
    }
    public void addNewFundraising(View view){
        startActivity(new Intent(inside_cluster_activity.this, create_new_fundraising.class));
    }
}