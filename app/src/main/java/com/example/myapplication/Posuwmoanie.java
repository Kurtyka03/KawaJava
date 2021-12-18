package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Posuwmoanie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posuwmoanie);

        //Importowanie

        TextView Rodzaj_Kawy_EditText = findViewById(R.id.RodzajKawy);
        TextView Dodatki_EditText = findViewById(R.id.Dodatki);
        TextView Dane_EditText = findViewById(R.id.Dane_Zamowenia);
        Switch Swch = findViewById(R.id.switch1);

        //-----\\

        //Zmienne\\
            //Przekazywane
            boolean Miod,Cukier,Mleko, PrzyprawaB;
            String Kawa, Rozmiar, Dodatek, Adres, Telefon;

            //Bazowe
            String MiodS = "\n-Miod", CukeirS = "\n-Cukier", MlekoS = "\n-Mleko";
            String Dodatki_Lista = "";

        //-------\\

        //GetIntent

        Miod = getIntent().getBooleanExtra("Miod", false);
        Cukier = getIntent().getBooleanExtra("Cukier", false);
        Mleko = getIntent().getBooleanExtra("Mleko", false);

        Rozmiar = getIntent().getStringExtra("Wielkosc");
        Kawa = getIntent().getStringExtra("Kawa");
        Adres = getIntent().getStringExtra("Adres");
        Telefon = getIntent().getStringExtra("Telefon");
        Dodatek = getIntent().getStringExtra("Przyprawa");
        PrzyprawaB = getIntent().getBooleanExtra("CzyPrzyprawa",false);

        //-------\\

        Rodzaj_Kawy_EditText.setText("Kawa " + Rozmiar + " " + Kawa + "z dodatkami: ");
        if(Miod){
            Dodatki_Lista = Dodatki_EditText.getText().toString() + MiodS;
            Dodatki_EditText.setText(Dodatki_Lista);
        }
        if(Cukier){
            Dodatki_Lista = Dodatki_EditText.getText().toString() + CukeirS;
            Dodatki_EditText.setText(Dodatki_Lista);
        }
        if(Mleko){
            Dodatki_Lista = Dodatki_EditText.getText().toString() + MlekoS;
        }
        if(!PrzyprawaB){
            Dodatki_EditText.setText(Dodatki_Lista);
            Toast.makeText(this, "bez dodatku", Toast.LENGTH_SHORT).show();
        }else{
            Dodatki_EditText.setText(Dodatki_Lista + Dodatek);
        }


        Dane_EditText.setText("Adres: " + Adres + "\nTelefon " + Telefon);

        Swch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = findViewById(R.id.button6);
                if(Swch.isChecked()){
                    btn.setEnabled(true);
                }else{
                    btn.setEnabled(false);
                }
            }
        });
    }

    public void Dalej(View view) {
        Intent i = new Intent(this, Ocena.class);
        startActivity(i);
    }
}