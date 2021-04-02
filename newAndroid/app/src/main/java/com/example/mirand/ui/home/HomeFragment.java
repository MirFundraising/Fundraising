package com.example.mirand.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mirand.R;
import com.example.mirand.adapters.UserCardRecycler;
import com.example.mirand.adapters.UserClustersRecycler;
import com.example.mirand.ui.adds.add_new_cluster;
import com.example.mirand.util.Cluster;
import com.example.mirand.util.Permission;
import com.example.mirand.util.User;

import java.util.Map;
import java.util.function.Function;

public class HomeFragment extends Fragment {

    private Function<Cluster,String> getClustersName=cluster -> cluster.getName();
    public User user;
    private HomeViewModel homeViewModel;
    private ImageView addCluster;
    private ImageView addCard;
    private RecyclerView clusterRecycler;
    private RecyclerView cardRecycler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        addCard=(ImageView)root.findViewById(R.id.add_new_card_image);
        addCluster=(ImageView)root.findViewById(R.id.add_new_cluster_image);
        clusterRecycler=(RecyclerView)root.findViewById(R.id.main_user_cluster_recycler);
        cardRecycler=(RecyclerView)root.findViewById(R.id.main_user_cards_recycler);

        String[] clusterNames= (String[]) user.getClusters().stream().map(getClustersName).toArray();
        Permission[] permissions= (Permission[]) user.getUserPermissionOnClusterId().values().toArray();
        Integer[] membersCounter= (Integer[]) user.getClusters().stream().map(cluster -> cluster.getUsers().stream().count()).toArray();
        String[] cards= (String[]) user.getUserCards().stream().map(card -> card.getCardNumber()).toArray();//это не то

        UserClustersRecycler userClustersRecycler=new UserClustersRecycler(this.getContext(),clusterNames,permissions,membersCounter,cards);
        clusterRecycler.setAdapter(userClustersRecycler);
        clusterRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));

        String[] card4Digits= (String[]) user.getUserCards().stream().map(card -> card.getCardNumber().substring(card.getCardNumber().length()-4)).toArray();
        String[] balances=new String[4];

        UserCardRecycler userCardRecycler=new UserCardRecycler(this.getContext(),card4Digits,balances);
        cardRecycler.setAdapter(userCardRecycler);
        cardRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
        addCluster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), add_new_cluster.class);
                startActivity(intent);

            }
        });
        return root;
    }

}