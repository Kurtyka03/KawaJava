package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Miejsce_Dostawy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miejsce_dostawy);
    }

    public void Cofnij(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void Dalej(View view) {
        Intent i = new Intent(this, Rodzaj_Kawy.class);
        startActivity(i);
    }
}