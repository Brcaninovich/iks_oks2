package com.brcaninovich.iks_okss;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.brcaninovich.iks_okss.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public int player_broj;     //Igrac koji je na redu
    public int brojac;          //Brojac poteza kako bi se odredilo da li je DRAW
    public boolean zauzeto;     //ZAUZETO POLJE
    public boolean zavrsenGejm; //Zavrsena partija


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        player_broj = 1;
        brojac = 0;
        zavrsenGejm = false;
        if(player_broj == 1){
            binding.xOrO.setText("X");
        }else{
            binding.xOrO.setText("O");
        }

    }

    public void set_value(View view) {
        if(((Button)view).getText().toString() == ""){
            zauzeto = false;
            brojac++;
        }else{
            zauzeto = true;

        }
        if(!zavrsenGejm){
            if(player_broj == 1 && !zauzeto){
                ((Button)view).setText("X");
                binding.xOrO.setText("O");
                player_broj = 2;
            }else if (player_broj == 2 && !zauzeto ){
                ((Button)view).setText("O");
                binding.xOrO.setText("X");
                player_broj = 1;
            }
            String test = gameplay.pobjeda(binding);
            if(test == null){
                if(brojac >= 9){
                    binding.winnerTV.setText("DRAW");
                    gameplay.winner(binding, 2);
                    zavrsenGejm = true;
                }
            }else{
                binding.winnerTV.setText(test);
                gameplay.winner(binding, 1);
                zavrsenGejm = true;

            }
        }



    }

    public void restart_game(View view) {
        navigateUpTo(new Intent(MainActivity.this, MainActivity.class));
        startActivity(getIntent());
        finish();
    }
}