package com.example.mirand.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mirand.util.Permission;

public class UserClustersRecycler extends RecyclerView.Adapter<UserClustersRecycler.MyViewHolder> {

    private String[] names;
    private Permission[] permissions;
    private String[] cardNumbers;
    private Context context;
    public UserClustersRecycler(Context context, String[] clusterName, Permission[] permission, String[] cardNumberMoneyHolder){
        this.context=context;
        names=clusterName;
        this.permissions=permission;
        cardNumbers=cardNumberMoneyHolder;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
