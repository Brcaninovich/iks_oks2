package com.brcaninovich.iks_okss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.brcaninovich.iks_okss.databinding.ActivityMainBinding;
import com.brcaninovich.iks_okss.databinding.ActivityOnlineBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OnlineActivity extends AppCompatActivity {

    public static DatabaseReference databaseReference3;
    String room_number = Activity_toGame.room_number;
    String username = Activity_toGame.user_name;
    ActivityOnlineBinding binding;

    String provjera;

    String[] playeri;
    int broj;
    int na_potezu = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnlineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseReference3 = FirebaseDatabase.getInstance().getReference(room_number);
        databaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                provjera = snapshot.getValue().toString();
                Log.d("Poruka", provjera);
                provjera = provjera.substring(1, provjera.length()-1);
                String[] tempArray= provjera.split(",");
                playeri[0] = tempArray[0];
                playeri[1] = tempArray[1];




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void set_value(View view) {
        if(playeri[0].equals(username)){
            broj = 1;
        }else if (playeri[1].equals(username)){
            broj = 2;
        }

        if(((Button)view).getText().equals("")){
            if(na_potezu == 1 && broj == 1){
                ((Button)view).setText("X");
                na_potezu = 2;
            }else{
                ((Button)view).setText("O");
                na_potezu = 1;
            }
            //Networking.set_value(room_number, na_potezu);
        }
    }

    public void restart_game(View view) {
    }
}