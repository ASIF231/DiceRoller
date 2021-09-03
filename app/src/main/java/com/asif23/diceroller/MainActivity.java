package com.asif23.diceroller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn,dual,coin;
    int n;
    TextView tv;
    ImageView imageViewDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.buttonroll);
        dual = findViewById(R.id.gotodoubleslide);
        tv= findViewById(R.id.textViewnumber);
        imageViewDice = findViewById(R.id.dice);
        final MediaPlayer mediaPlayersingledice = MediaPlayer.create(this,R.raw.move);
        coin = findViewById(R.id.btncoin);

        coin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CoinToss.class);
                startActivity(intent);
                finish();
            }
        });

        dual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,activity_Dual_Dice.class);
                startActivity(intent);
                finish();

            }
        });

//        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//                = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment fragment;
//                switch (item.getItemId()) {
//                    case R.id.single_dice:
//                        Intent intent = new Intent(MainActivity.this,activity_Dual_Dice.class);
//                        startActivity(intent);
//                        return true;
//                    case R.id.double_dice:
//                        return true;
//
//                }
//                return false;
//            }
//        };
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   mediaPlayersingledice.start();
                   Random j = new Random();
                   n = j.nextInt(6)+1;
                   tv.setText(String.valueOf(n));

                   switch (n) {
                       case 1:
                           imageViewDice.setImageResource(R.drawable.dice1);
                           break;
                       case 2:
                           imageViewDice.setImageResource(R.drawable.dice2);
                           break;
                       case 3:
                           imageViewDice.setImageResource(R.drawable.dice3);
                           break;
                       case 4:
                           imageViewDice.setImageResource(R.drawable.dice4);
                           break;
                       case 5:
                           imageViewDice.setImageResource(R.drawable.dice5);
                           break;
                       case 6:
                           imageViewDice.setImageResource(R.drawable.dice6);
                           break;
                   }
               }
               catch (Exception e){
                   Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}