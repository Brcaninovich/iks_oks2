package com.brcaninovich.iks_okss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OnlineActivity extends AppCompatActivity {

    public static DatabaseReference databaseReference3;
    String room_number = Activity_toGame.room_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);

        databaseReference3 = FirebaseDatabase.getInstance().getReference(room_number);
    }
}