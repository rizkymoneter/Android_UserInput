package com.example.androiddasaruserinput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edSisi;
    Button btnHitung;
    TextView tvHasil;
    Spinner spinnerPilihan;
    String[] pilihanHitung = {"Volume" , "Keliling" , "Luas Permukaan"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edSisi          = findViewById(R.id.ed_Sisi);
        btnHitung       = findViewById(R.id.btn_Hitung);
        tvHasil         = findViewById(R.id.tv_Hasil);
        spinnerPilihan  = findViewById(R.id.spinner_Pilihan);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[0])) {
                    rumusVolume();
                }
                else if(spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[1])){
                    rumusKeliling();
                }
                else if(spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[2])){
                    Double sisi = Double.valueOf(edSisi.getText().toString()); // mengambil data dari edSisi lalu di parsing
                    rumusLuaspermukaan(sisi);
                }
            }
        });

        //pembuatan Array Adapter untuk pilihan perhitungan | pilihan perhitungan merupakan data
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, pilihanHitung);
        spinnerPilihan.setAdapter(adapter);
    }

    private void rumusLuaspermukaan(Double sisi) {
        Double hasil = 12 * sisi;
        tvHasil.setText(hasil.toString());
    }

    private void rumusKeliling() {
        Double sisi = Double.valueOf(edSisi.getText().toString()); // mengambil data dari edSisi lalu di parsing
        Double hasil = 6 * sisi * sisi;
        tvHasil.setText(hasil.toString());
    }

    private void rumusVolume() {
        Double sisi = Double.valueOf(edSisi.getText().toString()); // mengambil data dari edSisi lalu di parsing
        Double hasil = sisi * sisi * sisi;
        tvHasil.setText(hasil.toString());
    }
}