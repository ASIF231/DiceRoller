package com.asif23.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn;
    int n;
    TextView tv;
    ImageView imageViewDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.buttonroll);
        tv= findViewById(R.id.textViewnumber);
        imageViewDice = findViewById(R.id.dice);
        final MediaPlayer mediaPlayersingledice = MediaPlayer.create(this,R.raw.move);


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