package com.example.rodneytressler.week4assessment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_team)
    protected EditText teamInput;

    @BindView(R.id.input_number)
    protected EditText numberInput;

    @BindView(R.id.input_name)
    protected EditText nameInput;

    private ArrayList<Player> playerList;

    public static final String TAG = "PLAYER_LIST_TAG";

    @OnClick(R.id.button_add_player)
    protected void onAddPlayerButtonClicked() {

        if (teamInput.getText().toString().length() == 0 ||
                numberInput.getText().toString().length() == 0 ||
                nameInput.getText().toString().length() == 0) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show();
        } else {
            Player player =  new Player(nameInput.getText().toString(), numberInput.getText().toString(), teamInput.getText().toString());
            playerList.add(player);
            Toast.makeText(this, "Player added successfully", Toast.LENGTH_SHORT).show();

            nameInput.setText("");
            numberInput.setText("");
            teamInput.setText("");
        }

    }



    @OnClick(R.id.button_view_players)
    protected void onViewPlayersButtonClicked() {

        if (playerList.isEmpty()) {
            Toast.makeText(this, "There are no players to display", Toast.LENGTH_LONG).show();
        } else {
            Intent playersActivity = new Intent(this, PlayersActivity.class);
            playersActivity.putParcelableArrayListExtra(TAG, playerList);
            startActivity(playersActivity);

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        playerList = new ArrayList<>();
    }


    
}
