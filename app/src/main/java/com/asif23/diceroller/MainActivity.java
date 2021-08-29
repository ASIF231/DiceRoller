package com.asif23.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn;
    String n;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.buttonroll);
        tv= findViewById(R.id.textViewnumber);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
//                   Random j = new Random();
                   List<Integer> givenList = Arrays.asList(1, 2, 3,4,5,6);
                   Random rand = new Random();
                   int j= givenList.get(rand.nextInt(givenList.size()));
                   n = String.valueOf(j);
                   tv.setText(n);
               }
               catch (Exception e){
                   Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}