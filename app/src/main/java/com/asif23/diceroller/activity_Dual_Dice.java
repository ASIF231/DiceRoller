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

import java.util.Random;

public class activity_Dual_Dice extends AppCompatActivity {
    Button btn,single;
    int n,n1,n2;
    TextView tv;
    ImageView imageViewDice1,imageViewDice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_dice);

        btn = findViewById(R.id.buttonroll);
        single = findViewById(R.id.gotosingle);
        tv= findViewById(R.id.textViewnumber);
        imageViewDice1 = findViewById(R.id.dice1);
        imageViewDice2 = findViewById(R.id.dice2);
        final MediaPlayer mediaPlayersingledice = MediaPlayer.create(this,R.raw.move);

        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_Dual_Dice.this,MainActivity.class);
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
//
//                        return true;
//                    case R.id.double_dice:
//                        Intent intent = new Intent(activity_Dual_Dice.this,MainActivity.class);
//                        startActivity(intent);
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
                    n1 = j.nextInt(6)+1;


                    switch (n1) {
                        case 1:
                            imageViewDice1.setImageResource(R.drawable.dice1);
                            break;
                        case 2:
                            imageViewDice1.setImageResource(R.drawable.dice2);
                            break;
                        case 3:
                            imageViewDice1.setImageResource(R.drawable.dice3);
                            break;
                        case 4:
                            imageViewDice1.setImageResource(R.drawable.dice4);
                            break;
                        case 5:
                            imageViewDice1.setImageResource(R.drawable.dice5);
                            break;
                        case 6:
                            imageViewDice1.setImageResource(R.drawable.dice6);
                            break;
                    }

                    n2 = j.nextInt(6)+1;
                    tv.setText(String.valueOf(n1+n2));

                    switch (n2) {
                        case 1:
                            imageViewDice2.setImageResource(R.drawable.dice1);
                            break;
                        case 2:
                            imageViewDice2.setImageResource(R.drawable.dice2);
                            break;
                        case 3:
                            imageViewDice2.setImageResource(R.drawable.dice3);
                            break;
                        case 4:
                            imageViewDice2.setImageResource(R.drawable.dice4);
                            break;
                        case 5:
                            imageViewDice2.setImageResource(R.drawable.dice5);
                            break;
                        case 6:
                            imageViewDice2.setImageResource(R.drawable.dice6);
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