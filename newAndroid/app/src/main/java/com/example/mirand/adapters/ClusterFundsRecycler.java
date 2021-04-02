package com.example.mirand.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mirand.R;
import com.example.mirand.ui.insides.InsideFundraisingActivity;
import com.example.mirand.ui.insides.inside_cluster_activity;
import com.example.mirand.util.Cluster;

public class ClusterFundsRecycler extends RecyclerView.Adapter<ClusterFundsRecycler.MyViewHolder>{

    private Context context;
    private String[] fundName;
    private String[] remainTimes;
    private Double[] goals;
    private Double[] currentSumm;

    public ClusterFundsRecycler(Context context, String[] fundName, String[] remainTimes, Double[] goals, Double[] currentSumm) {
        this.context = context;
        this.fundName = fundName;
        this.remainTimes = remainTimes;
        this.goals = goals;
        this.currentSumm = currentSumm;
    }

    @NonNull
    @Override
    public ClusterFundsRecycler.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.activity_card_row,parent,false);
        return new ClusterFundsRecycler.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClusterFundsRecycler.MyViewHolder holder, int position) {
        holder.fName.setText(fundName[position]);
        holder.remTime.setText(remainTimes[position]);
        holder.fGoals.setText(goals[position]+"");
        holder.curSumm.setText(currentSumm[position]+"");
        holder.cardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, InsideFundraisingActivity.class);
                intent.putExtra("fname",fundName[position]);
                intent.putExtra("remTime",remainTimes[position]);
                intent.putExtra("fgola",goals[position]);
                intent.putExtra("currentSumm",currentSumm[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fundName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView fName, remTime, fGoals,curSumm;
        ConstraintLayout cardLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fName=itemView.findViewById(R.id.funraising_row_name_text);
            remTime=itemView.findViewById(R.id.fundraising_row_expire_time_text);
            fGoals=itemView.findViewById(R.id.fundraising_row_goal_text);
            curSumm=itemView.findViewById(R.id.fundraising_row_current_fundraising_text);
        }
    }
}
