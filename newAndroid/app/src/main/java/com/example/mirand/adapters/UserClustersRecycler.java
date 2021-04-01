package com.example.mirand.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mirand.R;
import com.example.mirand.util.Permission;

public class UserClustersRecycler extends RecyclerView.Adapter<UserClustersRecycler.MyViewHolder> {

    private String[] names;
    private Permission[] permissions;
    private String[] cardNumbers;
    private Context context;
    private Integer[] counter;
    public UserClustersRecycler(Context context, String[] clusterName, Integer[] counter, Permission[] permission, String[] cardNumberMoneyHolder){
        this.context=context;
        names=clusterName;
        this.counter=counter;
        this.permissions=permission;
        cardNumbers=cardNumberMoneyHolder;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.cluster_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,permission,memberCounter,cardNumber;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.cluster_name_text);
            permission=itemView.findViewById(R.id.user_permission_text);
            memberCounter=itemView.findViewById(R.id.members_count_text);
            cardNumber=itemView.findViewById(R.id.cluster_output_number_text);
        }
    }
}
