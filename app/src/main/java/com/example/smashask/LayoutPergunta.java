package com.example.smashask;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LayoutPergunta extends AppCompatActivity implements View.OnClickListener {

    private Pergunta pergunta;
    private BancoDeDados bd;
    private SharedPreferences shared;
    private String s1, correta;
    private int idLista, numeroDaPergunta, tamanhoLista;
    private TextView t1, textNP, textP, textA, textB, textC, textD;
    private Button btnA, btnB, btnC, btnD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_pergunta);

        shared = getSharedPreferences("dados", 0);
        bd = new BancoDeDados((getApplicationContext()));
        pergunta = new Pergunta();

        t1 = (TextView) findViewById(R.id.textViewTimer);
        s1 = shared.getString("Modo", null);
        if(s1.equals(R.string.smashS) ){
            t1.setVisibility(View.INVISIBLE);
        }else{
            // roda timer
        }
        idLista = shared.getInt("IdLista",1);
        numeroDaPergunta = shared.getInt("NP", 1);
        tamanhoLista = bd.buscaTamLista(idLista);
        pergunta = bd.buscaPerguntaNaLista(idLista, numeroDaPergunta);


        textNP =(TextView) findViewById(R.id.textViewNumeroPergunta);
        textNP.setText("Pergunta"+numeroDaPergunta+"/"+tamanhoLista);
        textP =(TextView) findViewById(R.id.textViewPergunta);
        textP.setText(pergunta.getPergunta());
        textA =(TextView) findViewById(R.id.textViewRespostaA);
        textA.setText(pergunta.getRespostaA());
        textB =(TextView) findViewById(R.id.textViewRespostaB);
        textB.setText(pergunta.getRespostaB());
        textC =(TextView) findViewById(R.id.textViewRespostaC);
        textC.setText(pergunta.getRespostaC());
        textD =(TextView) findViewById(R.id.textViewRespostaD);
        textD.setText(pergunta.getRespostaD());

        btnA = (Button) findViewById(R.id.buttonA);
        btnA.setOnClickListener(this);
        btnB = (Button) findViewById(R.id.buttonB);
        btnB.setOnClickListener(this);
        btnC = (Button) findViewById(R.id.buttonC);
        btnC.setOnClickListener(this);
        btnD = (Button) findViewById(R.id.buttonD);
        btnD.setOnClickListener(this);

        correta = pergunta.getRespostaCorreta();
    }

    @Override
    public void onClick(View v) {
        shared = getSharedPreferences(getString(R.string.pref_Key), 0);
        SharedPreferences.Editor edit = shared.edit();
        if(v == btnA){
            if(btnA.getText().equals(correta)){
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta++));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);

                    //camputa que esta correta

                    this.finish();
                }else{
                    //termina a lista
                    //camputa que esta correta
                }


            }else{
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta++));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);

                    //camputa que esta errado

                    this.finish();
                }else{
                    //termina a lista
                    //camputa que esta errado
                }

            }
        }
        if(v == btnB){
            if(btnB.getText().equals(correta)){
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta++));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);

                    //camputa que esta correta

                    this.finish();
                }else{
                    //termina a lista
                    //camputa que esta correta
                }


            }else{
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta++));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);

                    //camputa que esta errado

                    this.finish();
                }else{
                    //termina a lista
                    //camputa que esta errado
                }

            }
        }
        if(v == btnC){
            if(btnC.getText().equals(correta)){

                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta++));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);

                    //camputa que esta correta

                    this.finish();
                }else{
                    //termina a lista
                    //camputa que esta correta
                }


            }else{
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta++));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);

                    //camputa que esta errado

                    this.finish();
                }else{
                    //termina a lista
                    //camputa que esta errado
                }
            }
        }
        if(v == btnD){
            if(btnD.getText().equals(correta)){

                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta++));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);

                    //camputa que esta correta

                    this.finish();
                }else{
                    //termina a lista
                    //camputa que esta correta
                }


            }else{
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta++));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);

                    //camputa que esta errado

                    this.finish();
                }else{
                    //termina a lista
                    //camputa que esta errado
                }
            }
        }
    }
}