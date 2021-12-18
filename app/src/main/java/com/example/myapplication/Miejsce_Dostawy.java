package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

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
        EditText TelefonEdit = findViewById(R.id.Telefon);
        EditText Adres = findViewById(R.id.Ares);
        boolean Telefon = Pattern.matches("^[0-9]{9}$", TelefonEdit.getText().toString());
        if(Telefon){
            if(Adres.getText().toString() != ""){
                i.putExtra("Adres", Adres.getText().toString());
                i.putExtra("Telefon", TelefonEdit.getText().toString());
                startActivity(i);
            }
            else{
                Toast.makeText(this, "Adres jest pusty!", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            if(Adres.getText().toString() == ""){
                Toast.makeText(this, "Zly telefon i Brak Adresu!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Zly numer telefonu!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}