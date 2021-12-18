package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Rodzaj_Kawy extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] Rodzaj_Kawy = {"Espresso","Cappuccino","Latte", "Americano"};
    String[] Dodatki = {"Kakao","Cynamon","Imbir", "Kardamon", "Wanilia"};
    String Wybrany_Dodatek, Wybrana_Kawa, TelefonC, AdresC;
    boolean CukierC = false, MiodC = false, MlekoC = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodzaj_kawy);
        Spinner spin = (Spinner) findViewById(R.id.Spiner);
        spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Rodzaj_Kawy);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);


        Spinner spin2 = (Spinner) findViewById(R.id.Spiner2);
        spin2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Dodatki);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(aa2);

        CheckBox Cukier = findViewById(R.id.Cukier);
        CheckBox Miod = findViewById(R.id.Miod);
        CheckBox Mleko = findViewById(R.id.MLeko);

        String Telefon = getIntent().getStringExtra("Telefon");
        String Adres = getIntent().getStringExtra("Adres");
        TelefonC = Telefon;
        AdresC = Adres;

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spin2.getSelectedItem().equals("Kakao")) Wybrany_Dodatek = "\n-Kakao";
                if(spin2.getSelectedItem().equals("Cynamon")) Wybrany_Dodatek ="\n-Cynamon";
                if(spin2.getSelectedItem().equals("Imbir")) Wybrany_Dodatek ="\n-Imbir";
                if(spin2.getSelectedItem().equals("Kardamon")) Wybrany_Dodatek = "\n-Kardamon";
                if(spin2.getSelectedItem().equals("Wanilia")) Wybrany_Dodatek = "\n-Wanilia";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Cukier.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox Cukier = findViewById(R.id.Cukier);
                if(Cukier.isChecked()) CukierC = true;
                else CukierC = false;
            }
        });
        Miod.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox Miod = findViewById(R.id.Miod);
                if(Miod.isChecked()) MiodC = true;
                else MiodC = false;
            }
        });
        Mleko.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox Mleko = findViewById(R.id.MLeko);
                if(Mleko.isChecked()) MlekoC = true;
                else MlekoC = false;
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Spinner spin = (Spinner) findViewById(R.id.Spiner);
        if(spin.getSelectedItem().equals("Espresso")) Wybrana_Kawa = "Espresso";
        if(spin.getSelectedItem().equals("Cappuccino")) Wybrana_Kawa = "Cappuccino";
        if(spin.getSelectedItem().equals("Latte")) Wybrana_Kawa = "Latte";
        if(spin.getSelectedItem().equals("Americano")) Wybrana_Kawa = "Americano";
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void Przyprawy(View view) {
        CheckBox Przyprawa = findViewById(R.id.PRzyprawa);
        Spinner spin2 = (Spinner) findViewById(R.id.Spiner2);
        TextView Dodatki = findViewById(R.id.Dodatek);
        if(Przyprawa.isChecked()){
            spin2.setVisibility(View.VISIBLE);
        }
        else{
            spin2.setVisibility(View.INVISIBLE);
            Dodatki.setText("");
        }
    }

    public void Cofnij(View view) {
        Intent i = new Intent(this, Miejsce_Dostawy.class);
        startActivity(i);
    }

    public void Dalej(View view) {
        CheckBox Przyprawa = findViewById(R.id.PRzyprawa);
        Intent i = new Intent(this, Posuwmoanie.class);
        RadioButton Mala = findViewById(R.id.Mala);
        RadioButton Srednia = findViewById(R.id.Srednia);
        RadioButton Duza = findViewById(R.id.Duza);
        boolean PrzyprawaB;

        if(Przyprawa.isChecked()) PrzyprawaB = true;
        else PrzyprawaB = false;

        i.putExtra("Miod", MiodC);
        i.putExtra("Cukier", CukierC);
        i.putExtra("Mleko", MlekoC);
        i.putExtra("CzyPrzyprawa", PrzyprawaB);
        if(Przyprawa.isChecked()){
            i.putExtra("Przyprawa", Wybrany_Dodatek);
        }
        if(Mala.isChecked()) i.putExtra("Wielkosc", "Mała");
        if(Srednia.isChecked()) i.putExtra("Wielkosc", "Srednia");
        if(Duza.isChecked()) i.putExtra("Wielkosc", "Duża");
        i.putExtra("Kawa", Wybrana_Kawa);
        i.putExtra("Telefon", TelefonC);
        i.putExtra("Adres", AdresC);
        startActivity(i);
    }
}