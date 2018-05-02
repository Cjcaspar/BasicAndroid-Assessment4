package com.example.rodneytressler.week4assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayersActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;

    private ArrayList<Player> playerList;

    private PlayerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        playerList = extras.getParcelableArrayList(MainActivity.TAG);
        populateRecyclerView();
    }

    private void populateRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        adapter = new PlayerAdapter(playerList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter.notifyDataSetChanged();

    }
}
