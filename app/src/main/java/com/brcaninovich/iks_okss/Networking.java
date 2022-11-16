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
    public static String temp_provjera;
    static Integer provjera_return;
    static boolean proc = true;


    public static String room_index;
    public static String room_username;

    public static void vraca_broj_aktivnih_soba(){
            databaseReference = FirebaseDatabase.getInstance().getReference("Aktivne_Sobe");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    temp_provjera = snapshot.getValue().toString();
                    temp_provjera = temp_provjera.substring(1, temp_provjera.length()-1);
                    String[] tempArray= temp_provjera.split(",");
                    provjera_return = tempArray.length;


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

    }

    public static void kreiraj_sobu(String string_sobe, String user_name){
        Log.d("Porukaaaa", brojac2.toString());
        try {
            broj_sobe = string_sobe;
            databaseReference = FirebaseDatabase.getInstance().getReference(broj_sobe);
            databaseReference.child("0").setValue(user_name);
            databaseReference = FirebaseDatabase.getInstance().getReference("Aktivne_Sobe");
            databaseReference.child("0").setValue(broj_sobe);


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

    public static void req_restart(String room_number){
        databaseReference = FirebaseDatabase.getInstance().getReference(room_number);
        databaseReference.child("12").setValue("1"); //RESTART
    }

    public static void popuni_pocetak_gejma(String room_number){
    try {
        databaseReference = FirebaseDatabase.getInstance().getReference(room_number);
        databaseReference.child("2").setValue("1");
        databaseReference.child("3").setValue("0"); //1
        databaseReference.child("4").setValue("0"); //2
        databaseReference.child("5").setValue("0"); //3
        databaseReference.child("6").setValue("0"); //4
        databaseReference.child("7").setValue("0"); //5
        databaseReference.child("8").setValue("0"); //6
        databaseReference.child("9").setValue("0"); //7
        databaseReference.child("10").setValue("0"); //8
        databaseReference.child("11").setValue("0"); //9
        databaseReference.child("12").setValue("0"); //RESTART

    }catch (Exception e){

    }
    }

    public static void set_value(String room_number, Integer broj_polja, Integer uradio_potez, Integer sledeci_potez){
        Integer temp = broj_polja + 2;
        Log.d("Porukica", room_number);
        databaseReference = FirebaseDatabase.getInstance().getReference(room_number);
        databaseReference.child("2").setValue(sledeci_potez.toString());
        databaseReference.child(temp.toString()).setValue(uradio_potez.toString());
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
