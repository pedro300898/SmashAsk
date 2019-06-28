package com.example.smashask;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class CodigoPerguntas extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private Switch sw1;
    private Button btn1, btn2, btn3;
    private TextView textTest, textStudy;
    private EditText editTextCodgoL;
    private SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_perguntas);
        sw1 = (Switch) findViewById(R.id.switchSmash);
        sw1.setOnCheckedChangeListener(this);

        btn1 = (Button) findViewById(R.id.btnCodgo);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.buttonCNP);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.buttonCNL);
        btn3.setOnClickListener(this);
        textStudy = (TextView) findViewById(R.id.textViewStudy);
        textTest = (TextView) findViewById(R.id.textViewTest);
        editTextCodgoL = (EditText) findViewById(R.id.editTextCodgoLista);

        shared = getSharedPreferences(getString(R.string.pref_Key), 0);
        SharedPreferences.Editor edit = shared.edit();
        edit.putString("Modo", "Smash Study");
        edit.putInt("NP", 1);
        edit.commit();
    }

    @Override
    public void onClick(View v) {
        if(v == btn1) {
            shared = getSharedPreferences("dados", 0);
            SharedPreferences.Editor edit = shared.edit();
            int idLista = Integer.parseInt(editTextCodgoL.getText().toString());
            edit.putInt("IdLista", idLista);
            edit.commit();
            Intent i = new Intent(this, LayoutPergunta.class);
            startActivity(i);
        }
        if(v == btn2){
            Intent i = new Intent(this, AdicionarPergunta.class);
            startActivity(i);
        }
        if(v == btn3){
            Intent i = new Intent(this, AdicionarLista.class);
            startActivity(i);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        shared = getSharedPreferences(getString(R.string.pref_Key), 0);
        SharedPreferences.Editor edit = shared.edit();

        if(buttonView == sw1){
            if(isChecked){
                //Entar usando modo Test
                edit.putString("Modo", "Smash Test");
                edit.putInt("NP", 1);
                edit.commit();
            }else{
                //Entrar usando modo estudo
                edit.putString("Modo", "Smash Study");
                edit.putInt("NP", 1);
                edit.commit();
            }
        }
    }
}
