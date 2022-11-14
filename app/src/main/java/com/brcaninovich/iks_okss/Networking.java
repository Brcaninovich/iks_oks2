package com.brcaninovich.iks_okss;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.brcaninovich.iks_okss.databinding.ActivityOnlineBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class Networking {

    public static DatabaseReference databaseReference;
    public static Integer brojac2 = 0;
    public static String temp;
    public static boolean tempic = false;
    public static String broj_sobe;
    public static boolean mozeProc;
    public static String provjera2;

    public static void kreiraj_sobu(String string_sobe, String user_name){
        try {
            broj_sobe = string_sobe;
            databaseReference = FirebaseDatabase.getInstance().getReference(broj_sobe);
            databaseReference.child("0").setValue(user_name);
            databaseReference = FirebaseDatabase.getInstance().getReference("Aktivne_Sobe");
            databaseReference.child(brojac2.toString()).setValue(broj_sobe);
            brojac2++;

        }catch (Exception e){
            Log.d("Probaa", "Test");
        }

    }

    public static void join_u_bazu(String string_sobe, String user_name){
        Log.d("Probaa", "Test");
        try{
            databaseReference = FirebaseDatabase.getInstance().getReference(string_sobe);
            databaseReference.child("1").setValue(user_name);
        }catch (Exception e){
            Log.d("Probaa", "Test");
        }
    }

    public static void set_value(String room_number, int broj){


    }


    public static void vrati_room(String unesena_soba, String username){
        temp = "x";
        Log.d("Poruka", unesena_soba);
        databaseReference = FirebaseDatabase.getInstance().getReference("Aktivne_Sobe");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                provjera2 = snapshot.getValue().toString();
                provjera2 = provjera2.substring(1, provjera2.length()-1);
                String[] tempArray= provjera2.split(",");
                for (int i = 0; i < tempArray.length; i++){
                    if(tempArray[i].equals(unesena_soba)){
                        temp = tempArray[i];
                        tempic = true;
                        if(tempic){
                            join_u_bazu(temp, username);
                            mozeProc = true;
                        }
                        break;
                    }else{
                        Log.d("Poruka", "1. Nema podudaranja");
                        tempic = false;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Log.d("Probaa", "Test");
    }
}
