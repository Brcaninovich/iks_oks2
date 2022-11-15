package com.brcaninovich.iks_okss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
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
    String username = Activity_toGame.user_name;
    ActivityOnlineBinding binding;

    String provjera;
    String player1;
    String player2;
    int broj;
    int na_potezu = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnlineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        na_potezu = 1;
        Log.d("Porukaaa", Activity_toGame.room_number);
        try{
            databaseReference3 = FirebaseDatabase.getInstance().getReference(Activity_toGame.room_number);
            databaseReference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                        provjera = snapshot.getValue().toString();
                        provjera = provjera.substring(1, provjera.length()-1);
                        String[] tempArray= provjera.split(", ");
                        if(tempArray[2].equals("2")){
                            binding.xOrO.setText("O" + "-"+tempArray[1]);
                            na_potezu = 2;
                        } else if (tempArray[2].equals("1")) {
                            binding.xOrO.setText("X"+ "-"+tempArray[0]);
                            na_potezu = 1;
                        }
                    if (tempArray[3].equals("1")) {
                        binding.polje1.setText("X");
                    }else if(tempArray[3].equals("2")){
                        binding.polje1.setText("O");
                    }if (tempArray[4].equals("1")) {
                        binding.polje2.setText("X");
                    }else if(tempArray[4].equals("2")){
                        binding.polje2.setText("O");
                    }if (tempArray[5].equals("1")) {
                        binding.polje3.setText("X");
                    }else if(tempArray[5].equals("2")){
                        binding.polje3.setText("O");
                    }if (tempArray[6].equals("1")) {
                        binding.polje4.setText("X");
                    }else if(tempArray[6].equals("2")){
                        binding.polje4.setText("O");
                    }if (tempArray[7].equals("1")) {
                        binding.polje5.setText("X");
                    }else if(tempArray[7].equals("2")){
                        binding.polje5.setText("O");
                    }if (tempArray[8].equals("1")) {
                        binding.polje6.setText("X");
                    }else if(tempArray[8].equals("2")){
                        binding.polje6.setText("O");
                    }if (tempArray[9].equals("1")) {
                        binding.polje7.setText("X");
                    }else if(tempArray[9].equals("2")){
                        binding.polje7.setText("O");
                    }if (tempArray[10].equals("1")) {
                        binding.polje8.setText("X");
                    }else if(tempArray[10].equals("2")){
                        binding.polje8.setText("O");
                    }if (tempArray[11].equals("1")) {
                        binding.polje9.setText("X");
                    }else if(tempArray[11].equals("2")){
                        binding.polje9.setText("O");
                    }
                        player1 = tempArray[0];
                        player2 = tempArray[1];
                    String teemp = gameplay.pobjeda_online(tempArray);
                    String temp;
                    if(teemp != null){
                        if(teemp.equals("X")){
                            temp = player1;
                        }else{
                            temp = player2;
                        }
                        binding.winnerTV.setText(temp);
                        gameplay.winner_online(binding, 1);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }catch (Exception e){

        }
    }

    public void set_value(View view) {

        Integer potez = 0;
        if(player1.equals(username)){
            broj = 1;
        }else if (player2.equals(username)){
            broj = 2;
        }
        if(((Button)view).getText().equals("")){
            if(na_potezu == 1 && broj == 1){
                ((Button)view).setText("X");
                potez = 1;
                na_potezu = 2;
            }else if(na_potezu == 2 && broj == 2){
                ((Button)view).setText("O");
                potez = 2;
                na_potezu = 1;
            }
            String temp = view.getResources().getResourceEntryName(view.getId());
            Integer broj_polja = Integer.parseInt(temp.substring(temp.length() - 1));
            Networking.set_value(Activity_toGame.room_number, broj_polja , potez, na_potezu);
        }
    }

    public void restart_game(View view) {
    }
}