package com.example.mirand.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mirand.R;
import com.example.mirand.database.Const;
import com.example.mirand.ui.home.HomeFragment;
import com.example.mirand.ui.insides.inside_cluster_activity;
import com.example.mirand.util.Permission;

import javax.crypto.ShortBufferException;

public class UserClustersRecycler extends RecyclerView.Adapter<UserClustersRecycler.MyViewHolder> {

    private String[] names;
    private Permission[] permissions;
    private Integer[] membersCounter;
    private String[] cardNumbers;
    private Context context;
    public UserClustersRecycler(Context context, String[] clusterName, Permission[] permission,Integer[] membersCounter, String[] cardNumberMoneyHolder){
        this.context=context;
        names=clusterName;
        this.membersCounter=membersCounter;
        this.permissions=permission;
        cardNumbers=cardNumberMoneyHolder;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.cluster_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(names[position]);
        holder.membersCount.setText(membersCounter[position]);
        holder.cardNumber.setText(cardNumbers[position]);
        holder.permission.setText(permissions[position].toString());
        holder.clusterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, inside_cluster_activity.class);
                intent.putExtra("name",names[position]);
                intent.putExtra("permission",permissions[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,permission,cardNumber,membersCount;
        ConstraintLayout clusterLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardNumber=itemView.findViewById(R.id.cluster_output_number_text);
            permission=itemView.findViewById(R.id.user_permission_text);
            name=itemView.findViewById(R.id.cluster_name_text);
            membersCount=itemView.findViewById(R.id.members_count_text);
            clusterLayout=itemView.findViewById(R.id.cluster_row_layout);
        }
    }
}
