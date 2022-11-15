package com.brcaninovich.iks_okss;

import android.util.Log;
import android.view.View;

import com.brcaninovich.iks_okss.databinding.ActivityMainBinding;
import com.brcaninovich.iks_okss.databinding.ActivityOnlineBinding;

public class gameplay {


    public static String pobjeda(ActivityMainBinding binding){
        String line = null;
        for(int i = 1; i < 9; i++){
            switch (i){
                case 1:
                    line =  binding.polje1.getText().toString() +
                            binding.polje2.getText().toString() +
                            binding.polje3.getText().toString();
                    break;
                case 2:
                    line =  binding.polje4.getText().toString() +
                            binding.polje5.getText().toString() +
                            binding.polje6.getText().toString();
                    break;
                case 3:
                    line =  binding.polje7.getText().toString() +
                            binding.polje8.getText().toString() +
                            binding.polje9.getText().toString();
                    break;
                case 4:
                    line =  binding.polje1.getText().toString() +
                            binding.polje4.getText().toString() +
                            binding.polje7.getText().toString();
                    break;
                case 5:
                    line =  binding.polje2.getText().toString() +
                            binding.polje5.getText().toString() +
                            binding.polje8.getText().toString();
                    break;
                case 6:
                    line =  binding.polje3.getText().toString() +
                            binding.polje6.getText().toString() +
                            binding.polje9.getText().toString();
                    break;
                case 7:
                    line =  binding.polje1.getText().toString() +
                            binding.polje5.getText().toString() +
                            binding.polje9.getText().toString();
                    break;
                case 8:
                    line =  binding.polje3.getText().toString() +
                            binding.polje5.getText().toString() +
                            binding.polje7.getText().toString();
                    break;
            }
            if(line.equals("XXX")){
                Log.d("Probaa", "XXX");
                return "X";
            }
            else if(line.equals("OOO")){
                Log.d("Probaa", "OOO");
                return "O";
            }
        }return null;
    }

    public static void winner(ActivityMainBinding binding, int broj){
        if(broj == 1){
            binding.winnerLayout.setVisibility(View.VISIBLE);
            binding.turnLayout.setVisibility(View.INVISIBLE);
        }else{
            binding.winnerisTV.setVisibility(View.GONE);
            binding.winnerLayout.setVisibility(View.VISIBLE);
            binding.turnLayout.setVisibility(View.INVISIBLE);
        }

    }

    public static void winner_online(ActivityOnlineBinding binding, int broj){
        if(broj == 1){
            binding.winnerLayout.setVisibility(View.VISIBLE);
            binding.turnLayout.setVisibility(View.INVISIBLE);
        }else{
            binding.winnerisTV.setVisibility(View.GONE);
            binding.winnerLayout.setVisibility(View.VISIBLE);
            binding.turnLayout.setVisibility(View.INVISIBLE);
        }

    }

    public static String pobjeda_online(String[] tempNiz){
        String line = null;
        for(int i = 1; i < 9; i++){
            switch (i){
                case 1:
                    line =  tempNiz[3] +
                            tempNiz[4] +
                            tempNiz[5];
                    break;
                case 2:
                    line =  tempNiz[6] +
                            tempNiz[7] +
                            tempNiz[8];
                    break;
                case 3:
                    line =  tempNiz[9] +
                            tempNiz[10] +
                            tempNiz[11];
                    break;
                case 4:
                    line =  tempNiz[3] +
                            tempNiz[6] +
                            tempNiz[9];
                    break;
                case 5:
                    line =  tempNiz[4] +
                            tempNiz[7] +
                            tempNiz[10];
                    break;
                case 6:
                    line =  tempNiz[5] +
                            tempNiz[8] +
                            tempNiz[11];
                    break;
                case 7:
                    line =  tempNiz[3] +
                            tempNiz[7] +
                            tempNiz[11];
                    break;
                case 8:
                    line =  tempNiz[5] +
                            tempNiz[7] +
                            tempNiz[9];
                    break;
            }
            if(line.equals("111")){
                Log.d("Probaa", "XXX");
                return "X";
            }
            else if(line.equals("222")){
                Log.d("Probaa", "OOO");
                return "O";
            }
        }return null;

    }
}
