package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Rodzaj_Kawy extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] Rodzaj_Kawy = {"Espresso","Cappuccino","Latte", "Americano"};
    String[] Dodatki = {"Kakao","Cynamon","Imbir", "Kardamon", "Wanilia"};
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

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView Dodatki = findViewById(R.id.Dodatek);
                if(spin2.getSelectedItem().equals("Kakao")) Dodatki.setText("Kakao");
                if(spin2.getSelectedItem().equals("Cynamon")) Dodatki.setText("Cynamon");
                if(spin2.getSelectedItem().equals("Imbir")) Dodatki.setText("Imbir");
                if(spin2.getSelectedItem().equals("Kardamon")) Dodatki.setText("Kardamon");
                if(spin2.getSelectedItem().equals("Wanilia")) Dodatki.setText("Wanilia");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        TextView RodzajKawy = findViewById(R.id.RodzajKawy);
        Spinner spin = (Spinner) findViewById(R.id.Spiner);
        if(spin.getSelectedItem().equals("Espresso")) RodzajKawy.setText("Espresso");
        if(spin.getSelectedItem().equals("Cappuccino")) RodzajKawy.setText("Cappuccino");
        if(spin.getSelectedItem().equals("Latte")) RodzajKawy.setText("Latte");
        if(spin.getSelectedItem().equals("Americano")) RodzajKawy.setText("Americano");
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
            if(spin2.getSelectedItem().equals("Kakao")) Dodatki.setText("Kakao");
            if(spin2.getSelectedItem().equals("Cynamon")) Dodatki.setText("Cynamon");
            if(spin2.getSelectedItem().equals("Imbir")) Dodatki.setText("Imbir");
            if(spin2.getSelectedItem().equals("Kardamon")) Dodatki.setText("Kardamon");
            if(spin2.getSelectedItem().equals("Wanilia")) Dodatki.setText("Wanilia");
        }
        else{
            spin2.setVisibility(View.INVISIBLE);
            Dodatki.setText("");
        }
    }

}