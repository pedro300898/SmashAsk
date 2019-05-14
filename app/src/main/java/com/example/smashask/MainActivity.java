package com.example.smashask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1.findViewById(R.id.BtnSmash);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btn1){
            //pegar os dados da seçao que esta logada

            Intent i = new Intent(this, CodigoPerguntas.class);
            startActivity(i);
            this.finish();
        }

    }
}
