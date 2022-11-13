package com.brcaninovich.iks_okss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.brcaninovich.iks_okss.databinding.ActivityToGameBinding;


public class Activity_toGame extends AppCompatActivity {

    private ActivityToGameBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityToGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }

    public void start_normal_game(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}