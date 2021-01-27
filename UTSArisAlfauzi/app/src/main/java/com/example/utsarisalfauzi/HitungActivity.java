package com.example.utsarisalfauzi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HitungActivity extends AppCompatActivity {

    EditText panjangTembok, LebarTembok, jumlahTembok, luasTembok;
    EditText panjangPintu, LebarPintu, jumlahPintu, luaspintu;
    EditText panjangJendela, LebarJendela, jumlahJendela, luasJendela, areaCat, kebutuhanCat, kebutuhanCatDasar;
    Button buttonHitung, buttonHapus;
    private double hasilTembok,hasilPintu,hasilJendela;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung);
        getSupportActionBar().hide();
        panjangTembok=(EditText)findViewById(R.id.editTextpanjangTembok);
        panjangPintu=(EditText)findViewById(R.id.editTextpanjangPintu);
        panjangJendela=(EditText)findViewById(R.id.editTextpanjangjendela);
        LebarTembok=(EditText)findViewById(R.id.editTextlebarTembok);
        LebarPintu=(EditText)findViewById(R.id.editTextlebarPintu);
        LebarJendela=(EditText)findViewById(R.id.editTextlebarjendela);
        jumlahTembok=(EditText)findViewById(R.id.editTextjumlahTembok);
        jumlahPintu=(EditText)findViewById(R.id.editTextjumlahPintu);
        jumlahJendela=(EditText)findViewById(R.id.editTextjumlahjendela);
        areaCat=(EditText)findViewById(R.id.editTextareacat);
        kebutuhanCat=(EditText)findViewById(R.id.editTextkebutuhancat);
        kebutuhanCatDasar=(EditText)findViewById(R.id.editTextkebutuhancatdasar);


        luasTembok=(EditText)findViewById(R.id.editTextluasTembok);
        luaspintu=(EditText)findViewById(R.id.editTextluaspintu);
        luasJendela=(EditText)findViewById(R.id.editTextluasjendela);


        buttonHapus=(Button)findViewById(R.id.buttonHapus);

        //Text Watcher Untuk Hitung Luas tembok
        TextWatcher textWatcher1 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!panjangTembok.getText().toString().equals("") && !LebarTembok.getText().toString().equals("") && !jumlahTembok.getText().toString().equals(""))
                {
                    //Hitung Luas Tembok
                    String pT = panjangTembok.getText().toString();
                    double dpT= Double.parseDouble(pT);
                    String lT = LebarTembok.getText().toString();
                    double dlT= Double.parseDouble(lT);
                    String jT = jumlahTembok.getText().toString();
                    double djT= Double.parseDouble(jT);
                    hasilTembok = dpT*dlT*djT;
                    luasTembok.setText(String.valueOf(hasilTembok));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        panjangTembok.addTextChangedListener(textWatcher1);
        LebarTembok.addTextChangedListener(textWatcher1);
        jumlahTembok.addTextChangedListener(textWatcher1);

        //TextWatche untuk Hitung Luas Pintu
        TextWatcher textWatcher2 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ( !panjangPintu.getText().toString().equals("") && !LebarPintu.getText().toString().equals("") && !jumlahPintu.getText().toString().equals(""))
                {
                    //Hitung Luas Pintu
                    String pP = panjangPintu.getText().toString();
                    double dpP= Double.parseDouble(pP);
                    String lP = LebarPintu.getText().toString();
                    double dlP= Double.parseDouble(lP);
                    String jP = jumlahPintu.getText().toString();
                    double djP= Double.parseDouble(jP);
                    hasilPintu = dpP*dlP*djP;
                    luaspintu.setText(String.valueOf(hasilPintu));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        panjangPintu.addTextChangedListener(textWatcher2);
        LebarPintu.addTextChangedListener(textWatcher2);
        jumlahPintu.addTextChangedListener(textWatcher2);

        TextWatcher textWatcher3 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ( !panjangJendela.getText().toString().equals("") && !LebarJendela.getText().toString().equals("") && !jumlahJendela.getText().toString().equals(""))
                {
                    //Hitung Luas Jendela
                    String pJ = panjangJendela.getText().toString();
                    double dpJ= Double.parseDouble(pJ);
                    String lJ = LebarJendela.getText().toString();
                    double dlJ= Double.parseDouble(lJ);
                    String jJ = jumlahJendela.getText().toString();
                    double djJ= Double.parseDouble(jJ);
                    hasilJendela = dpJ*dlJ*djJ;
                    luasJendela.setText(String.valueOf(hasilJendela));
                    //Hasil Hitung Area yang di Cat
                    double hasilareaCat = hasilTembok-hasilPintu-hasilJendela;
                    areaCat.setText(String.valueOf(hasilareaCat));
                    //Hasil hitung kebutuhan Cat Tembok
                    double hasilKebutuhanCat = hasilareaCat/6;
                    kebutuhanCat.setText(String.valueOf(hasilKebutuhanCat));
                    //Hasil hitung Kebutuhan Cat Dasar
                    double hasilkebutuhanCatDasar = hasilKebutuhanCat/2;
                    kebutuhanCatDasar.setText(String.valueOf(hasilkebutuhanCatDasar));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        panjangJendela.addTextChangedListener(textWatcher3);
        LebarJendela.addTextChangedListener(textWatcher3);
        jumlahJendela.addTextChangedListener(textWatcher3);

        buttonHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panjangTembok.setText("");
                LebarTembok.setText("");
                jumlahTembok.setText("");
                luasTembok.setText("");
                panjangPintu.setText("");
                LebarPintu.setText("");
                jumlahPintu.setText("");
                luaspintu.setText("");
                panjangJendela.setText("");
                LebarJendela.setText("");
                jumlahJendela.setText("");
                luasJendela.setText("");
                panjangTembok.requestFocus();
                areaCat.setText("");
                kebutuhanCat.setText("");
                kebutuhanCatDasar.setText("");
            }
        });
    }
}