package com.example.smashask;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class LayoutPergunta extends AppCompatActivity {

    private SharedPreferences shared;
    private String s1;
    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_pergunta);
        t1.findViewById(R.id.textViewTimer);


        shared = getSharedPreferences(getString(R.string.pref_Key), 0);

        s1 = shared.getString("modo", null);
        if(s1.equals(R.string.smashS) ){
            t1.setVisibility(View.INVISIBLE);
        }else{
            // roda timer
        }
    }
}
