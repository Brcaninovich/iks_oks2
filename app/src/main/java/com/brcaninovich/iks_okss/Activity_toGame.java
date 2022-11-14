package com.brcaninovich.iks_okss;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.brcaninovich.iks_okss.databinding.ActivityToGameBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Activity_toGame extends AppCompatActivity {

    private ActivityToGameBinding binding;
    String room_number;
    String user_name;
    String provjera;

    public static DatabaseReference databaseReference2;
    boolean kreiranje_sobe = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityToGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        room_number = "2558";

        try{
            databaseReference2 = FirebaseDatabase.getInstance().getReference(room_number);
            databaseReference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(kreiranje_sobe){
                        provjera = snapshot.getValue().toString();
                        provjera = provjera.substring(1, provjera.length()-1);
                        String[] tempArray= provjera.split(",");
                        Log.d("Poruka", ((Integer)tempArray.length).toString());
                        if(tempArray[tempArray.length - 1] != user_name){
                            temp(); //radi
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.d("Poruka", "greska");
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public void temp(){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }


    public void start_normal_game(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void create_multiplayer(View view) {
        binding.joinLayout.setVisibility(View.VISIBLE);
        user_name = binding.usernameET.getText().toString();
        binding.usernameET.setEnabled(false);
        binding.joinCodeTV.setText(room_number);
        Networking.kreiraj_sobu(room_number, user_name);
        kreiranje_sobe = true;
        binding.multiplayerCreate.setEnabled(false);
    }

    public void join_multiplayer(View view) {

    }

    public void multiplayerLayoutShow(View view) {
        binding.multiplayerLayout.setVisibility(View.VISIBLE);
        binding.buttonsLayout.setVisibility(View.INVISIBLE);
    }

    public void botGameStart(View view) {
    }
}