package com.example.mirand.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mirand.R;
import com.example.mirand.ui.insides.inside_cluster_activity;

public class UserCardRecycler extends RecyclerView.Adapter<UserCardRecycler.MyViewHolder>{
    private Context context;
    private String[] lastDigits;
    private String[] balance;

    public UserCardRecycler(Context context, String[] lastDigits, String[] balance) {
        this.context = context;
        this.lastDigits = lastDigits;
        this.balance = balance;
    }

    @NonNull
    @Override
    public UserCardRecycler.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.activity_card_row,parent,false);
        return new UserCardRecycler.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserCardRecycler.MyViewHolder holder, int position) {
        holder.last4Digits.setText(lastDigits[position]);
        holder.balance.setText(balance[position]);
        holder.cardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, inside_cluster_activity.class);
                intent.putExtra("last_digits",lastDigits[position]);
                intent.putExtra("balance",balance[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lastDigits.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView last4Digits,balance;
        ImageView img;
        ConstraintLayout cardLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            last4Digits=itemView.findViewById(R.id.last_card_digits);
            balance=itemView.findViewById(R.id.card_balance);
            cardLayout=itemView.findViewById(R.id.card_row_constrained);
            img=itemView.findViewById(R.id.mir_card_pick);
        }
    }
}
