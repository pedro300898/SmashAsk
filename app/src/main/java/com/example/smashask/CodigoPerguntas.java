package com.example.smashask;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class CodigoPerguntas extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private Switch sw1;
    private Button btn1, btn2;
    private TextView textTest, textStudy;
    private SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_perguntas);
        sw1 = (Switch) findViewById(R.id.switchSmash);
        sw1.setOnCheckedChangeListener(this);

        btn1.findViewById(R.id.btnCodgo);
        btn1.setOnClickListener(this);
        btn2.findViewById(R.id.btnAleatorio);
        btn2.setOnClickListener(this);
        textStudy.findViewById(R.id.textViewStudy);
        textTest.findViewById(R.id.textViewTest);



    }

    @Override
    public void onClick(View v) {
        if(v == btn1){
            // Chama lista pelo códgo
        }else{
            // Chama Lista Aleatoria
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        shared = getSharedPreferences(getString(R.string.pref_Key), 0);
        SharedPreferences.Editor edit = shared.edit();

        if(buttonView == sw1){
            if(isChecked){
                //Entar usando modo Test
                edit.putString("modo", textTest.getText().toString());
                edit.commit();
            }else{
                //Entrar usando modo estudo
                edit.putString("modo", textStudy.getText().toString());
                edit.commit();
            }
        }
    }
}
