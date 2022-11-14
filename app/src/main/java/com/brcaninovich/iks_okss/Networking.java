package com.brcaninovich.iks_okss;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class Networking {

    public static DatabaseReference databaseReference;
    public static Integer brojac = 0;
    public static String broj_sobe;

    public static void kreiraj_sobu(String string_sobe, String user_name){
        try {
            broj_sobe = string_sobe;
            databaseReference = FirebaseDatabase.getInstance().getReference(broj_sobe);
            databaseReference.child(brojac.toString()).setValue(user_name);
            brojac++;

        }catch (Exception e){
            Log.d("Probaa", "Test");
        }

    }


}
