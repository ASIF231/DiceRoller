package com.asif23.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class CoinToss extends AppCompatActivity {

    Button btn,dual,single;
    int n;
    TextView tv;
    ImageView imageViewDice;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_toss);
        btn = findViewById(R.id.buttonroll);
        dual = findViewById(R.id.cointodouble);
        tv= findViewById(R.id.textViewnumber);
        imageViewDice = findViewById(R.id.dice);
        final MediaPlayer mediaPlayersingletoss = MediaPlayer.create(this,R.raw.coinflip);
        single = findViewById(R.id.cointossgotosingle);

        single.setOnClickListener(view -> {
            Intent intent = new Intent(CoinToss.this,MainActivity.class);
            startActivity(intent);
            finish();
        });

        dual.setOnClickListener(view -> {
            Intent intent = new Intent(CoinToss.this,activity_Dual_Dice.class);
            startActivity(intent);
            finish();

        });
        btn.setOnClickListener(view -> {
            try {
                mediaPlayersingletoss.start();
                Random j = new Random();
                n = j.nextInt(2)+1;


                switch (n) {
                    case 1:
                        imageViewDice.setImageResource(R.drawable.heads);
                        tv.setText("Heads");
                        break;
                    case 2:
                        imageViewDice.setImageResource(R.drawable.tails);
                        tv.setText("Tails");
                        break;

                }
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}